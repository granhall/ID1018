package EU4;
import java.util.Random;
@SuppressWarnings("Duplicates")
public class Test {

    public static void main(String[] args) {

        Polyline polyline = null;

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


        System.out.println("Polylines task 6");
        Random rand = new Random();
        System.out.println("Testing random VPolyline: ");
        System.out.println();
        int colour;
        int nofPoints;
        Polyline[] vp = new VPolyline[7];
        for(int i = 0; i < vp.length; i++) {
            vp[i] = new VPolyline();
            colour = rand.nextInt(2);
            switch(colour) {
                case 0:
                    vp[i].setColour("Yellow");
                    break;
                case 1:
                    vp[i].setColour("Blue");
                    break;
                case 2:
                    vp[i].setColour("Red");
                    break;
            }
            vp[i].setWidth(rand.nextInt(7));
            nofPoints =6;
            while(nofPoints > 0) {
                vp[i].add(randomPoint());
                nofPoints--;
            }
            System.out.println(vp[i].toString());

        }
        System.out.println();
        Polylines.shortYellow(vp);
        System.out.println();
        System.out.println("Testing random NPolyline: ");
        System.out.println();
        Polyline[] np = new NPolyline[7];
        for(int i = 0; i < np.length; i++) {
            np[i] = new NPolyline();
            colour = rand.nextInt(2);
            switch(colour) {
                case 0:
                    np[i].setColour("Yellow");
                    break;
                case 1:
                    np[i].setColour("Blue");
                    break;
                case 2:
                    np[i].setColour("Red");
                    break;
            }
            np[i].setWidth(rand.nextInt(7));
            nofPoints = 6;
            while(nofPoints > 0) {
                np[i].add(randomPoint());
                nofPoints--;
            }
            System.out.println(np[i].toString());

        }
        System.out.println();
        Polylines.shortYellow(np);
        System.out.println();
        System.out.println("Testing random both NPolyine and VPolyline: ");
        System.out.println();
        int type;
        Polyline[] vpolnpol = new Polyline[7];
        for(int i = 0; i < vpolnpol.length; i++) {
            type = rand.nextInt(2);
            switch (type) {
                case 0:
                    vpolnpol[i] = new VPolyline();
                    break;
                case 1:
                    vpolnpol[i] = new NPolyline();
                    break;
            }
            colour = rand.nextInt(3);
            switch(colour) {
                case 0:
                    vpolnpol[i].setColour("Yellow");
                    break;
                case 1:
                    vpolnpol[i].setColour("Blue");
                    break;
                case 2:
                    vpolnpol[i].setColour("Red");
                    break;
            }
            vpolnpol[i].setWidth(rand.nextInt(7));
            nofPoints = 6;
            while(nofPoints > 0) {
                vpolnpol[i].add(randomPoint());
                nofPoints--;
            }
            switch (type) {
                case 0:
                    System.out.println("VPolyline: " + vpolnpol[i].toString());
                    break;
                case 1:
                    System.out.println("NPolyline: " + vpolnpol[i].toString());
            }

        }
        System.out.println();
        Polylines.shortYellow(vpolnpol);
    }

    public static Point randomPoint () {
        Random rand = new Random();
        String n = "" + (char) (65 + rand.nextInt (26));
        int x = rand.nextInt (11);
        int y = rand.nextInt (11);
        return new Point (n, x, y);
    }

}
