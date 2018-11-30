package OU5;

import java.io.*; //importing for PrintWriter

public class PointTest {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        // Testing a constructor and a transformer
        Point p1 = new Point("A", 3, 4);
        Point p2 = new Point("B", 5, 6);
        out.println(p1 + "  " + p2);

        // Testing inspectors
        String n = p1.getName();
        int x = p1.getX();
        int y = p1.getY();
        out.println(n + " " + x + " " + y);

        //Testing a combiner and a comparator
        double d = p1.distance(p2);
        out.println(d);
        boolean b = p1.equals(p2);
        out.println(b);

        //Testing mutators
        p2.setX(1);
        p2.setY(2);
        out.println(p2);


        //Testing another constructor
        Point p = new Point(p1);
        out.println(p);
    }
}
