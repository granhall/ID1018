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

            //Determine the shortest yellow polyline

            //show the selected polyline

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

        }
// Assign a colour
    }
}
