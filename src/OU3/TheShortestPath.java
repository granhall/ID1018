/* The method intermediate stations returns a vector of the intermadiate stations
that are on the shortest path. The ordinal number of the first station is located in index
1 of the vector, and the second station on index 2. */

package OU3;

class TheShortestPath {
    public static int [] intermediateStations ( double [] a, double [] [] b, double [] c) {
        int [] position = new int [2];

        double shortest = a[0] + b[0][0] + c[0];

        for(int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (shortest > a[i]+b[i][j]+c[j]) {
                    shortest = a[i] + b[i][j] + c[j];
                    position[0] = i + 1;
                    position[1] = j + 1;
                }
            }
        }
        return position;
} 


// Next, The method length returns the length of the shortest path. 
    public static double length(double [] a, double [][] b, double [] c) {
        double shortest = a[0] + b[0][0] + c[0];

        for(int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (shortest > a[i]+b[i][j]+c[j]) {
                    shortest = a[i] + b[i][j] + c[j];
                }
            }
        }
        return shortest;  
    }
}