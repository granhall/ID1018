package OU5;

public class PolylineTest {
    public static void main(String[] args) {
        Point p1 = new Point("A", 1, 2);
        Point p2 = new Point("B", 3, 4);
        Point p3 = new Point("C", 5, 6);
        Point p4 = new Point("D", 7, 8);
        System.out.println("Point one is " + p1 + " and the rest are: " + p2 + " " + p3 + " " + p4); // testing to string

        Point[] points = {p1, p2, p3, p4};
        Polyline poly = new Polyline(points);

        poly.setColour("Blue"); // Setting Colour
        System.out.println(" After setting the colour, it should go from black to " + poly.getColour());
        poly.setWidth(3);
        System.out.println(" The width goes from 1 to " + poly.getWidth());
        System.out.println(" The length of the poly line is : ");
        System.out.println();
        System.out.println(poly.length());

        System.out.println("Add last test with point p1, named A");
        poly.addLast(p1);
        System.out.println(poly);

        System.out.println("addBefore test with point D before B");
        poly.addBefore(p4, "B");
        System.out.println(poly);

        System.out.println("Testing remove by removing C");
        poly.remove("C");
        System.out.println(poly);

        Polyline.PolylineIterator iterator = poly.new PolylineIterator();
        System.out.println("Iterator Test: ");
            while (iterator.hasVertex()){
                System.out.println(iterator.vertex().getName() + "," + iterator.vertex().getX() + ", " + iterator.vertex().getY());
                iterator.advance();
        }


    }
}
