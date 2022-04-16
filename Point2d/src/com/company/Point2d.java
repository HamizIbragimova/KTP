package com.company;

public class Point2d {
    /** координата X **/
    private double xCoord;
    /** координата Y **/
    private double yCoord;
    private Object obj;
    /** Конструкторинициализации **/
    public Point2d ( double x, double y) {
        xCoord= x;
        yCoord= y;
    }
    /** Конструкторпоумолчанию. **/
    public Point2d () {
//Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0);
    }
    /** Возвращение координаты X **/
    public double getX() {
        return xCoord;
    }
    /** Возвращение координаты Y **/
    public double getY() {
        return yCoord;
    }
    /** Установка значения координаты X. **/
    public void setX( double val) {
        xCoord= val;
    }
    /** Установка значения координаты Y. **/
    public void setY( double val) {
        yCoord= val;
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
        Point2d point2d = (Point2d) obj;
        return this.xCoord== point2d.xCoord &&this.yCoord== point2d.yCoord;
    }
}


