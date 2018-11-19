package com.you07.util;


public class GisUtils {
	/**
	 * 格式化面
	 * @param polygon
	 * @return
	 */
	public static String formatPolygon(String polygon){
		StringBuffer result = new StringBuffer();
		StringBuffer tempBuf = new StringBuffer();
		String coordinates[] = polygon.replace("MULTIPOLYGON", "").replace("(((", "").replace(")))", "").split(",");
		for (int i = 0; i < coordinates.length; i++) {
			String coordinate = coordinates[i];
			coordinate = coordinate.trim();
			String lonlat[] = coordinate.split(" ");
			tempBuf.append("[")
				.append(lonlat[0])
				.append(",")
				.append(lonlat[1])
				.append("]");
				if(coordinates.length-1!=i){
					tempBuf.append(",");
				}
		}
		return result.append("[")
				.append(tempBuf.toString())
				.append("]").toString();
	}
	/**
	 * 格式化点
	 * @param point
	 * @return
	 */
	public static String formatPoint(String point){
		String coordinates[] = point.replace("POINT", "")
									.replace("(", "")
									.replace(")", "")
									.trim()
									.split(" ");
		return "[" + coordinates[0] + "," + coordinates[1] + "]";
	}
//	/**
//	 * 格式化线
//	 * @param polyline
//	 * @return
//	 */
//	public static String formatPolyline(String polyline){
//		StringBuffer result = new StringBuffer();
//		StringBuffer tempBuf = new StringBuffer();
//		String coordinates[] = polyline.replace("MULTILINESTRING", "").replace("((", "").replace("))", "").split(",");
//		for (String coordinate : coordinates) {
//			coordinate = coordinate.trim();
//			String lonlat[] = coordinate.split(" ");
//			tempBuf.append("[")
//				.append(lonlat[0])
//				.append(",")
//				.append(lonlat[1])
//				.append("],");
//		}
//		return result.append("[")
//				.append(StringUtil.deleteLastStr(tempBuf.toString()))
//				.append("]").toString();
//	}
	/**
	 * 计算两点之间的距离
	 * @param p1 线段起始端点  [113.3,33.2]
	 * @param p2 线段结束端点   [114.5,33.8]
	 * @return 距离(米)
	 */
	public static double getDistance(double[]p1,double[] p2) {
        double radLat1 = p1[1] * Math.PI / 180;
        double radLat2 = p2[1] * Math.PI / 180;
        double a = radLat1 - radLat2;
        double b = p1[0] * Math.PI / 180 - p2[0] * Math.PI / 180;
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * 6378137.0;
        s = Math.round(s * 10000d) / 10000d;
        return s;
    }
	/**
	 * 计算几何线段的距离
	 * @param multiLineString
	 * @return 距离(米)
	 */
	public static double getLineStringDistance(double[] multiLineString){
		if(multiLineString.length < 4){
			return 0d;
		}else{
			double distance = 0;
			for(int i = 0; (i+2) < multiLineString.length; i= i+2){
				double[] start = {multiLineString[i], multiLineString[i+1]};
				double[] end = {multiLineString[i+2], multiLineString[i+3]};	
				distance += getDistance(start, end);
			}
			return distance;
		}
	}
	/**
	 * 求点到直线的垂直交点坐标
	 * @param startPoint 线起始点坐标
	 * @param endPoint 先结束点坐标
	 * @param point 点
	 * @return 垂直交点坐标
	 */
	public static double[] getCrossPoint(double[] startPoint, double[] endPoint, double[] point){
		double  A = (startPoint[1] - endPoint[1])/(startPoint[0] - endPoint[0]);
		double B = startPoint[1] - A * startPoint[0];
		double M = point[0] + A * point[1];
		double p0 = (M- A*B)/(A * A +1);
		double p1 = A * p0 + B;
		double[] crossPoint = {p0, p1};
		return crossPoint;
	}
	public static void main(String[] args) {
		double[] startPoint = {104.19680552974343,30.56477093324292};
		double[] endPoint = {104.1972525863788,30.565465302853344};
		double[] point = {104.19654483762638,30.564918527016548};
		GisUtils.getCrossPoint(startPoint, endPoint, point);
		
//		double[] startPoint = {0,0};
//		double[] endPoint = {1,1};
//		double[] point = {0,1};
//		GisUtils.getCrossPoint(startPoint, endPoint, point);
		
//		double [] p1 = {104.19654483762638,30.564918527016548};
//		double [] p2 = {104.19654483762638,30.564918427016548};
//		System.out.println(GisUtils.getDistance(p1, p2) * 2);
//		double [] multiLineString = {104.19654483762638,30.564918527016548,104.19866393862257,30.565466374164618,104.19654483762638,30.564918527016548,104.19866393862257,30.565466374164618};
//		System.out.println(GisUtils.getLineStringDistance(multiLineString));
	}
}
