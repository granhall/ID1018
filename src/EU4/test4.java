package EU4;

public class test4 {

    public static void main(String[] args) {
        Polyline polyline;
        //polyline = new VPolyline();
        polyline = new NPolyline();

        System.out.println("An empty Polyline => "+ polyline.toString());

        Point[] points = new Point[]{
                new Point("A", 1, 2),
                new Point("B", 5, 7),
                new Point("C", 2, 3),
                new Point("D", 1, 9),
                new Point("E", 6, 3)
        };
        //polyline = new VPolyline(points);
        polyline = new NPolyline(points);

        polyline.setColour("Red");
        polyline.setWidth(3);
        System.out.println("\nA Polyline with points => "+ polyline.toString());

        polyline.add(new Point("just a name", 7,7));
        polyline.remove("E");
        polyline.insertBefore(new Point("O",0,0), "C");
        System.out.println("\nA Polyline => "+ polyline.toString());
    }
}