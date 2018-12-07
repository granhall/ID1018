package OU5;

public class Point {
    private String name;
    private int x;
    private int y;

    public Point(){   //default constructor
    }

    public  Point(String name, int x, int y){  //explicit constructor
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public Point(Point p) { // copy constructor where 'p' is point being copied
        name = p.name;
        x = p.x;
        y = p.y;
    }
    public String toString(){
        return "(" + this.name + "," + this.x + "," + this.y + ")";
}

    public String getName() {
        return name;
    } // inspector for Name

    public  int getX() {
        return x;
    }

    public  int getY() {
        return y;
    } // inspector for Y


    public void setX(int x) { //mutator for X
        this.x = x;
    }

    public void setY(int y) { //mutator for Y
        this.y = y;
    }

    public  double distance(Point p){ //distance method
        return Math.sqrt(Math.pow((x - p.x),2) + Math.pow((y- p.y),2));
    }
}
