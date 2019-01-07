package EU4;

public class Polylines {
    public static void shortYellow(Polyline[] polylines){
        int i = 0;
        int yellowCurrent = 0;
        double length = 0;
        for (i = 0; i < polylines.length; i++){
            if (polylines[i].getColour().equals("yellow")){ //finds length of first yellow line and uses it's value
                length = polylines[i].length();
                yellowCurrent = i;
                break;
            }
        }
        for (i = 0; i < polylines.length; i++){
            if (polylines[i].getColour().equals("yellow") && polylines[i].length() < length){
                length = polylines[i].length();
                yellowCurrent = i;
            }
        }
        if (length != 0)
            System.out.println("Shortest yellow polyline: " + polylines[yellowCurrent].toString());
        else {
            System.out.println("No yellow polyline");
        }
    }
}
