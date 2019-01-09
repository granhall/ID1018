package EU4;
import java.util.Random;
@SuppressWarnings("Duplicates")
public class Test {

    public static Point randomP() {
        Random r = new Random();
        String s = "" + (char) (65 + r.nextInt(26));
        int x = r.nextInt(10);
        int y = r.nextInt(10);
        return new Point(s, x, y);
    }

    public static void main(String[] args) {

        Polyline polyline = null;
       // System.out.println(" Currently : " + polyline.toString());

        Point[] points = new Point[]{
                new Point("A", 1, 2),
                new Point("B", 3, 4),
                new Point("C", 5, 6),
                new Point("D", 4, 6),
                new Point("E", 5, 6),
                new Point("F", 3, 8)};
        polyline = new VPolyline(points);
        //polyline = new NPolyline(points);
        System.out.println(" After point: " + polyline.toString());
        polyline.setWidth(9);
        polyline.setColour("blue");
        System.out.println("After adding width and colour: " + polyline.toString());

        polyline.add(new Point("J", 6, 9));
        polyline.remove("C");
        System.out.println("After adding and removing: " + polyline.toString());
        polyline.insertBefore(new Point("C", 9, 9), "D");
        System.out.println("After adding back C: " + polyline.toString());
        System.out.println("\n");


        System.out.println("\n Now to test Polylines task 6");
        Random rand = new Random();
        int colour;
        int pointsinarray;
        Polyline[] vpoly = new VPolyline[6];
        for (int i = 0; i < vpoly.length; i++) {
            vpoly[i] = new VPolyline();
            colour = rand.nextInt(2);
            switch (colour) {
                case 0:
                    vpoly[i].setColour("blue");
                    break;
                case 1:
                    vpoly[i].setColour("yellow");
                    break;
                case 2:
                    vpoly[i].setColour("red");
                    break;
            }
            vpoly[i].setWidth(2);
            pointsinarray = 6;
            while (pointsinarray > 0) {
                vpoly[i].add(randomP());
                pointsinarray--;
            }
            System.out.println(vpoly[i].toString());
        }
        System.out.println("\n");
        Polylines.shortYellow(vpoly);

        System.out.println("\n");
        System.out.println(" Now for NPoly: \n");
        Polyline[] npoly = new NPolyline[6];
        for (int i = 0; i < npoly.length; i++) {
            npoly[i] = new NPolyline();
            colour = rand.nextInt(2);
            switch (colour) {
                case 0:
                    npoly[i].setColour("blue");
                    break;
                case 1:
                    npoly[i].setColour("yellow");
                    break;
                case 2:
                    npoly[i].setColour("red");
                   break;
            }
            npoly[i].setWidth(2);
            pointsinarray = 6;
            while (pointsinarray > 0) {
                npoly[i].add(randomP());
                pointsinarray--;
           }
            System.out.println(npoly[i].toString());
        }
       System.out.println("\n");
       Polylines.shortYellow(npoly);

        System.out.println("\n");
        System.out.println(" Now for VPoly AND NPoly : \n");

        int type;
        Polyline[] vnpoly = new Polyline[6];
        for (int i = 0; i < vnpoly.length; i++) {
            type = rand.nextInt(2);
            switch (type) {
                case 0:
                    vnpoly[i] = new VPolyline();
                    break;
                case 1:
                    vnpoly[i] = new NPolyline();
            }
            colour = rand.nextInt(2);
            switch (colour) {
                case 0:
                    vnpoly[i].setColour("blue");
                    break;
                case 1:
                    vnpoly[i].setColour("yellow");
                    break;
                case 2:
                    vnpoly[i].setColour("red");
                    break;
            }
            vnpoly[i].setWidth(2);
            pointsinarray = 6;
            while (pointsinarray > 0) {
                vnpoly[i].add(randomP());
                pointsinarray--;
            }
            switch (type){
                case 0: System.out.println("Printing Vpoly:" + vnpoly[i].toString());
                break;
                case 1:
                    System.out.println("Prinint Npoly: " + vnpoly[i].toString());
            }
        }
        System.out.println("\n");
        Polylines.shortYellow(vnpoly);
    }
}