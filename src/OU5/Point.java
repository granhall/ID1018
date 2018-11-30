package OU5;

public class Point {
    String name;
    int x;
    int y;

    public Point(){   //default constructor
    }

    public  Point(String id, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        name = p.name;
        x = p.x;
        y = p.y;
    }

    public String getName() {
        return name;
    }

    public  int getX() {
        return x;
    }

    public  int getY() {
        return y;
    }

}
