package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Point2d myPoint = new Point2d ();//создаетточку (0,0)
        Point2d myOtherPoint = new Point2d (5,3);//создаетточку (5,3)
        Point2d aThirdPoint = new Point2d ();//создаетточку (0,0)
        System.out.println(myPoint.equals(myOtherPoint));
        System.out.println(myPoint.equals(aThirdPoint));
        System.out.println(myOtherPoint.equals(aThirdPoint));
        Point3d point3d_1 = new Point3d(0.8,1.0,0.2);
        Point3d point3d_2 = new Point3d(0.8,1.0,0.2);
        Point3d point3d_3 = new Point3d(5.8,1.8,0.5);
/**Вывод равенства координат между двумя точками **/
        System.out.println(point3d_1.equals(point3d_2));
        System.out.println(point3d_1.equals(point3d_3));
/**Вывод расстояния с точностью до двух знаков после запятой **/
        System.out.printf("%.2f",point3d_1.distanceTo(point3d_3));
    }
}
