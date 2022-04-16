package com.company;

public class Point3d {
    /** координата X **/
    private double xCoord;
/** координата Y **/
    private double yCoord;
/** координата Z **/
    private double zCoord;
    /** Конструктор инициализации **/
    public Point3d ( double x, double y,double z) {
        xCoord= x;
        yCoord= y;
        zCoord= z;
    }
    /** Конструктор по умолчанию. **/
    public Point3d () {
//Вызовите конструктор с тремя параметрами и определите источник.
        this(0.0, 0.0, 0.0);
    }
    /** Возвращение координаты X **/
    public double getX() {
        return xCoord;
    }
    /** Возвращение координаты Y **/
    public double getY() {
        return yCoord;
    }
    /** Возвращение координаты Z **/
    public double getZ() {
        return zCoord;
    }
    /** Установка значения координаты X. **/
    public void setX( double val) {
        xCoord= val;
    }
    /** Установка значения координаты Y. **/
    public void setY( double val) {
        yCoord= val;
    }
    /** Установка значения координаты Z. **/
    public void setZ( double val) {
        zCoord= val;
    }
    /** Cравнение двух точек. **/
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if ( !getClass().equals(obj.getClass()) )
            return false;
        Point3d point3d = (Point3d) obj;
        return this.xCoord== point3d.xCoord &&this.yCoord== point3d.yCoord &&this.zCoord== point3d.zCoord;
    }
    /** Поискрасстояниямеждуточками **/
    public double distanceTo(Point3d p) {
        return Math.sqrt(Math.pow(xCoord- p.getX(), 2) + Math.pow(yCoord- p.getY(), 2) + Math.pow(zCoord- p.getZ(), 2));
    }

}
