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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author egan
 * @date 2019/11/26 16:43
 * @desc 测试数据生成器
 */
//@Api(tags = {"数据生成"})
@RestController
public class DataGenerator {

    @Autowired
    private LocationLatestDao locationLatestDao;

    @Autowired
    private LocationCampusInfoDao locationCampusInfoDao;

    @Autowired
    private StudentInfoService studentInfoService;

    @GetMapping("/generate")
    @Transactional
    public MessageBean generate(GeneratorForm form) throws IOException {
        LocationCampusInfo campus = locationCampusInfoDao.loadDefaultCampus(form.getCampusId());
        if(campus == null)
            throw new NullPointerException("校区不存在");

        List<StudentVO> students = studentInfoService.getStudentList(form.getSize());
        Map<String, ClassVO> classMap = studentInfoService.getClassMap();
        Map<String, MajorVO> majorMap = studentInfoService.getMajorMap();
        Map<String, AcademyVO> academyMap = studentInfoService.getAcademyMap();

        List<Coordinate> polygon = CoordinateUtil.convertStrToList(campus.getCoordinates());
        Double maxX = polygon.stream().map(Coordinate::getX).max(Double::compareTo).get();
        Double minX = polygon.stream().map(Coordinate::getX).min(Double::compareTo).get();
        Double maxY = polygon.stream().map(Coordinate::getY).max(Double::compareTo).get();
        Double minY = polygon.stream().map(Coordinate::getY).min(Double::compareTo).get();
        int pow = (int) Math.pow(10, 14); // 用于提取指定小数位

        for(StudentVO studentVO : students){
            //产生随机数
            Double x = Math.floor((Math.random() * (maxX - minX) + minX) * pow) / pow;
            Double y = Math.floor((Math.random() * (maxY - minY) + minY) * pow) / pow;

            Coordinate coordinate = new Coordinate(x,y);

            LocationLatest locationLatest = new LocationLatest();
            locationLatest.setRealname(studentVO.getRealName());
            locationLatest.setOrgs(academyMap.get(majorMap.get(classMap.get(studentVO.getClassCode()))));
            locationLatest.setLng(coordinate.x);
            locationLatest.setLat(coordinate.y);
            locationLatest.setFloorid("0");
            locationLatest.setAccountMac("vtpl-test-data");
            locationLatest.setInDoor(1);
            locationLatest.setZoneId(form.getCampusId());
            locationLatest.setUsrUpdateTime(new Date(System.currentTimeMillis()));
            locationLatest.setLocationTime(form.getLocationTime());

            if (CoordinateUtil.isInPolygon(coordinate, polygon)) {
                locationLatest.setInSchool(1);
            } else {
                locationLatest.setInSchool(2);
            }

            locationLatestDao.insert(locationLatest);
        }


        return new MessageBean();
    }
}
