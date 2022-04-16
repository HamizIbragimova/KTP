package com.company;

public class Point2d {
    private double xCoord; //координата X
    private double yCoord; //координата Y
    private Object obj;
    public Point2d ( double x, double y) { //Конструктор инициализации
        xCoord= x;
        yCoord= y;
    }
    public Point2d () { //Конструктор поумолчанию.
//Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0);
    }
    public double getX() {
        return xCoord;
    } //Возвращение координаты X
    public double getY() {
        return yCoord;
    } //Возвращение координаты Y
    public void setX( double val) {
        xCoord= val;
    } //Установка значения координаты X.
    public void setY( double val) {
        yCoord= val;
    } //Установка значения координаты Y
    public boolean equals(Object obj) //Cравнение двух точек
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if ( !getClass().equals(obj.getClass()) )
            return false;
        Point2d point2d = (Point2d) obj;
        return this.xCoord== point2d.xCoord &&this.yCoord== point2d.yCoord;
    }
}
