package EU4;

@SuppressWarnings("Duplicates")
public class Test {
    public static void main(String[] args)
    {
        shortestYellowV();
        shortestYellowN();
        shortestYellowNV();
    }

    private static void shortestYellowV(){
        Polyline longestNonYellowPolyline = new VPolyline(
                new Point[]{
                        new Point("A", 0,0),
                        new Point("B", 10,10)});
        longestNonYellowPolyline.setColour("Red");

        Polyline longYellowPolyline = new VPolyline(
                new Point[]{
                        new Point("A", 0,0),
                        new Point("B", 7,7)});
        longYellowPolyline.setColour("Yellow");

        Polyline shortestYellowPolyline = new VPolyline(
                new Point[]{
                        new Point("A", 0,0),
                        new Point("B", 1,1)});
        shortestYellowPolyline.setColour("Yellow");

        Polyline emptyYellowPolyline = new VPolyline();
        emptyYellowPolyline.setColour("Yellow");

        Polyline[] polylines = new Polyline[]
                {
                        longestNonYellowPolyline,
                        longYellowPolyline,
                        shortestYellowPolyline,
                        longYellowPolyline,
                        emptyYellowPolyline,
                        longestNonYellowPolyline
                };

        System.out.println("Shortest yellow Polyline => "
                + shortestYellow(polylines).toString());
    }

    private static void shortestYellowN()
    {
        Polyline longestNonYellowPolyline = new NPolyline(
                new Point[]{
                        new Point("A", 0,0),
                        new Point("B", 10,10)});
        longestNonYellowPolyline.setColour("Red");

        Polyline longYellowPolyline = new NPolyline(
                new Point[]{
                        new Point("A", 0,0),
                        new Point("B", 7,7)});
        longYellowPolyline.setColour("Yellow");

        Polyline shortestYellowPolyline = new NPolyline(
                new Point[]{
                        new Point("A", 0,0),
                        new Point("B", 1,1)});
        shortestYellowPolyline.setColour("Yellow");

        Polyline emptyYellowPolyline = new NPolyline();
        emptyYellowPolyline.setColour("Yellow");

        Polyline[] polylines = new Polyline[]
                {
                        longestNonYellowPolyline,
                        longYellowPolyline,
                        shortestYellowPolyline,
                        longYellowPolyline,
                        emptyYellowPolyline,
                        longestNonYellowPolyline
                };

        System.out.println("Shortest yellow Polyline => "
                + shortestYellow(polylines).toString());
    }

    private static void shortestYellowNV(){
        Polyline longestNonYellowPolyline = new NPolyline(
                new Point[]{
                        new Point("A", 0,0),
                        new Point("B", 10,10)});
        longestNonYellowPolyline.setColour("Red");

        Polyline longYellowPolyline = new VPolyline(
                new Point[]{
                        new Point("A", 0,0),
                        new Point("B", 7,7)});
        longYellowPolyline.setColour("Yellow");

        Polyline shortestYellowPolyline = new NPolyline(
                new Point[]{
                        new Point("A", 0,0),
                        new Point("B", 1,1)});
        shortestYellowPolyline.setColour("Yellow");

        Polyline emptyYellowPolyline = new VPolyline();
        emptyYellowPolyline.setColour("Yellow");

        Polyline[] polylines = new Polyline[]
                {
                        longestNonYellowPolyline,
                        longYellowPolyline,
                        shortestYellowPolyline,
                        longYellowPolyline,
                        emptyYellowPolyline,
                        longestNonYellowPolyline
                };

        System.out.println("Shortest yellow Polyline => "
                + shortestYellow(polylines).toString());
    }
    private static Polyline shortestYellow(Polyline[] polylines)
    {
        Polyline currentPolyline = null;
        boolean yellowFound = false;
        if (polylines.length > 0){
            int i = 0;
            while (i < polylines.length){
                if (polylines[i].getColour().equals("Yellow")
                        && polylines[i] != null
                        && polylines[i].getVertices() != null
                        && polylines[i].getVertices().length > 0
                )
                {
                    if (!yellowFound) {
                        currentPolyline = polylines[i];
                        yellowFound = true;
                    } else {
                        if (polylines[i].length() < currentPolyline.length()) {
                            currentPolyline = polylines[i];
                        }
                    }
                }
                i++;
            }
        }
        return currentPolyline;
    }
}
