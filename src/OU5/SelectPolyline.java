package OU5;

import java.util.Random;

public class SelectPolyline {
    public static final Random rand = new Random();
    public static final int NOF_POLYLINES = 10;

    public static void main(String[] args) {
        //create a random number of polylines
        Polyline[] polylines = new Polyline[NOF_POLYLINES];
        for (int i = 0; i < NOF_POLYLINES; i++) {
            polylines[i] = randomPolyline();
        }
            // Show the Polyline
        for (int i = 0; i < NOF_POLYLINES; i++){
            System.out.println((i+1) + " : " + polylines[i].toString() + " length of: " + polylines[i].length());
        }
            //Determine the shortest yellow polyline
        double shortestY = Double.MAX_VALUE; //declare shortest variable
        Polyline yellowPoly = new Polyline(); // create new polyline object
        for (Polyline poly: polylines) {
            if (poly.getColour().equals("yellow") && (poly.length() < shortestY)) { // cycle through using update strategy
                yellowPoly = poly; // if yellow condition is met
                shortestY = poly.length(); // if length condition is met
            }
        }
            //show the selected polyline
        System.out.println(" The shortest yellow polyline is: " + yellowPoly + " with the length: " + shortestY ); // using toString method provided earlier
    }
    // The randomPoint method returns a new Point with a name
// randomly chosen from the single letters A--Z. Coordinates
// are random .
    public static Point randomPoint () {
        String n = "" + (char) (65 + rand.nextInt(26));
        int x = rand.nextInt(11);
        int y = rand.nextInt(11);
        return new Point(n,x,y);
    }
    // The method randomPolyline returns a random polyline ,
// with a colour either blue , red , or yellow . The names
// of the vertices are single letters from the set A--Z.
// Two vertices can not have the same name .
    public static Polyline randomPolyline(){
        // Create an empty polyline and add vertices
        Polyline polyline = new Polyline ();
        int nofVertices = 2 + rand . nextInt (7);
        int nofSelectedVertices = 0;
        boolean [] selectedNames = new boolean [26];

        // Two vertices can not have the same name
        Point chosenPoint = null ;
        char chosenChar = 0;

        while ( nofSelectedVertices < nofVertices ) {

            chosenPoint = randomPoint();
            boolean selected = selectedNames[chosenPoint.getName().charAt(0)-65];
            if (!selected){
                selectedNames[chosenPoint.getName().charAt(0)-65] = true;
                polyline.addLast(chosenPoint);
                nofSelectedVertices++;
            }
        }
// Assign a colour
        polyline.setColour(randomColour());
        return polyline;
    }
    public static String randomColour(){
        String colour = "";
        int randColour = rand.nextInt(3);
        if (randColour == 0) {
            colour = "blue";
        } else if (randColour == 1) {
            colour = "red";
        } else if (randColour == 2) {
            colour = "yellow";
        }
        return  colour;
    }
}
