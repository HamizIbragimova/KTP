package com.company;

public class Point3d {
    private double xCoord; //координата X
    private double yCoord; //координата Y
    private double zCoord; // координата Z
    public Point3d ( double x, double y,double z) { //Конструктор инициализации
        xCoord= x;
        yCoord= y;
        zCoord= z;
    }
    public Point3d () { //Конструктор по умолчанию
//Вызовите конструктор с тремя параметрами и определите источник.
        this(0.0, 0.0, 0.0);
    }
    public double getX() {
        return xCoord;
    } //Возвращение координаты X
    public double getY() {
        return yCoord;
    } //Возвращение координаты Y
    public double getZ() {
        return zCoord;
    } //Возвращение координаты Z
    public void setX( double val) {
        xCoord= val;
    } //Установка значения координаты X.
    public void setY( double val) {
        yCoord= val;
    } //Установка значения координаты Y.
    public void setZ( double val) {
        zCoord= val;
    } //Установка значения координаты Z
    public boolean equals(Object obj) //Cравнение двух точек
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
    public double distanceTo(Point3d p) { //вычисляет расстояние между двумя точками  и возвращает полученное значение
        return Math.sqrt(Math.pow(xCoord- p.getX(), 2) + Math.pow(yCoord- p.getY(), 2) + Math.pow(zCoord- p.getZ(), 2));
    }

}
