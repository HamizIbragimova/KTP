package com.company;

public class Main {

    public static void main(String[] args) {

        Point3d point3d_1 = new Point3d(0.8,1.0,0.2);
        Point3d point3d_2 = new Point3d(0.8,1.0,0.2);
        Point3d point3d_3 = new Point3d(5.8,1.8,0.5);
/**Выводравенствакоординатмеждудвумяточками **/
        System.out.println(point3d_1.equals(point3d_2));
        System.out.println(point3d_1.equals(point3d_3));
/**Выводрасстояниясточностьюдодвухзнаковпослезапятой **/
        System.out.printf("%.2f",point3d_1.distanceTo(point3d_3));

    }
}
