package OU3;
import java.util.*;

class DetermineTheShortestPath {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        System.out.println("Enter the number of stations in ZONE 2: ");
        int zone2 = in.nextInt();

        System.out.println("Enter the number of stations in ZONE 3: ");
        int zone3 = in.nextInt();
        


        double [] a = new double[zone2];
        double [][] b = new double[zone2][zone3];
        double [] c = new double[zone3];

        System.out.println("Enter the distance from Station X (zone 1) to the staions in zone 2: ");
            for (int d = 0; d < a.length; d ++) {
                a[d] = in.nextDouble();
            }
        System.out.println("Enter the distance from stations in zone 2 to zone 3");
            for (int i = 0; i < b.length; i++) {
                System.out.println("Station U" + (i + 1) + " to stations in zone 3: " );
                for (int j = 0; j < b[i].length; j++) {
                    b[i][j] = in.nextDouble();
                }
                System.out.println();
                
            }
        System.out.println("Enter the distance from stations in zone 3 to Station Y: ");
            for (int i = 0; i < c.length; i ++) {
                c[i] = in.nextDouble();
            }
        System.out.println("The shortest distance you can take is " + TheShortestPath.length(a, b, c));
        int [] postion = TheShortestPath.intermediateStations(a, b, c);
        System.out.println("Which will be done by following path from X to U" + postion[0] + " to V" + postion[1] + " Then finally to Y" );
        
        
        in.close();
    }
}