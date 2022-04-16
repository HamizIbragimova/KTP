package com.company;

public class Main {

    public static void main(String[] args) {
            Point2d myPoint = new Point2d ();//создаетточку (0,0)
            Point2d myOtherPoint = new Point2d (5,3);//создаетточку (5,3)
            Point2d aThirdPoint = new Point2d ();//создаетточку (0,0)
            System.out.println(myPoint.equals(myOtherPoint));
            System.out.println(myPoint.equals(aThirdPoint));
            System.out.println(myOtherPoint.equals(aThirdPoint));


    }
}
