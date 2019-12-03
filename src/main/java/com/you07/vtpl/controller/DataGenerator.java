package com.you07.vtpl.controller;

import com.you07.config.message.MessageBean;
import com.you07.eas.service.StudentInfoService;
import com.you07.eas.vo.*;
import com.you07.util.CoordinateUtil;
import com.you07.vtpl.dao.LocationCampusInfoDao;
import com.you07.vtpl.dao.LocationLatestDao;
import com.you07.vtpl.form.GeneratorForm;
import com.you07.vtpl.model.LocationCampusInfo;
import com.you07.vtpl.model.LocationLatest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author egan
 * @date 2019/11/26 16:43
 * @desc 测试数据生成器
 */
@Api(tags = {"测试数据管理"})
@RestController
public class DataGenerator {

    @Autowired
    private LocationLatestDao locationLatestDao;

    @Autowired
    private LocationCampusInfoDao locationCampusInfoDao;

    @Autowired
    private StudentInfoService studentInfoService;

    @ApiOperation("生成测试数据")
    @GetMapping("/generate")
    @Transactional
    public MessageBean generate(@Valid GeneratorForm form) throws IOException, ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(form.getLocationTime());

        LocationCampusInfo campus = locationCampusInfoDao.selectByPrimaryKey(form.getCampusId());
        if(campus == null)
            throw new NullPointerException("校区不存在");

        List<StudentVO> students = studentInfoService.getStudentList(form.getSize());
        Map<String, ClassVO> classMap = studentInfoService.getClassMap();
        Map<String, MajorVO> majorMap = studentInfoService.getMajorMap();
        Map<String, AcademyVO> academyMap = studentInfoService.getAcademyMap();

        List<Point2D.Double> polygon = CoordinateUtil.convertStrToList(campus.getCoordinates());
        Double maxX = polygon.stream().map(Point2D.Double::getX).max(Double::compareTo).get();
        Double minX = polygon.stream().map(Point2D.Double::getX).min(Double::compareTo).get();
        Double maxY = polygon.stream().map(Point2D.Double::getY).max(Double::compareTo).get();
        Double minY = polygon.stream().map(Point2D.Double::getY).min(Double::compareTo).get();
        int pow = (int) Math.pow(10, 14); // 用于提取指定小数位

        for(StudentVO studentVO : students){
            //产生随机数
            Double x = Math.floor((Math.random() * (maxX - minX) + minX) * pow) / pow;
            Double y = Math.floor((Math.random() * (maxY - minY) + minY) * pow) / pow;

            Point2D.Double coordinate = new Point2D.Double(x,y);

            ClassVO classVO = classMap.get(studentVO.getClassCode());
            if(classVO == null)
                continue;
            MajorVO majorVO = majorMap.get(classVO.getClassCode());
            if(majorVO == null)
                continue;
            AcademyVO academyVO = academyMap.get(majorVO.getAcademyCode());
            if(academyVO == null)
                continue;

            LocationLatest locationLatest = new LocationLatest(studentVO, academyVO);
            locationLatest.setLng(coordinate.x);
            locationLatest.setLat(coordinate.y);
            locationLatest.setFloorid("1");
            locationLatest.setAccountMac("vtpl-test-data");
            locationLatest.setInDoor(1);
            locationLatest.setZoneId(String.valueOf(form.getCampusId()));
            locationLatest.setUsrUpdateTime(new Date(System.currentTimeMillis()));
            locationLatest.setLocationTime(date);
            if (CoordinateUtil.isInPolygon(coordinate, polygon)) {
                locationLatest.setInSchool(1);
            } else {
                locationLatest.setInSchool(2);
            }

            locationLatestDao.insert(locationLatest);
        }

        return new MessageBean();
    }

    @ApiOperation("清空测试数据(部分删除/完全删除)")
    @GetMapping("/clear")
    public MessageBean clear(boolean complete){
        locationLatestDao.clearTestData();
        if(complete){
            locationLatestDao.clearTestYearData();
            locationLatestDao.clearTestMonthData();
            locationLatestDao.clearTestDayData();
        }
        return new MessageBean();
    }
}
