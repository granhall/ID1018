package OU5;
@SuppressWarnings("Duplicates")
public class Polyline1 {

    private Point[] vertices;
    private String colour = "black";
    private int width = 1;

    public Polyline1() {
        this.vertices = new Point[0];
    }

    public Polyline1(Point[] vertices) {
        this.vertices = new Point[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            this.vertices[i] = new Point(vertices[i]);
        }
    }

    public String toString() {
        StringBuilder pointinfo = new StringBuilder();
        for (Point vertex : this.vertices) {
            pointinfo.append(vertex.toString()); //IDE recommended the use of StringBuilder instead of concatenation
            pointinfo.append(",");
        }
        return "(" + pointinfo + " " + colour + " " + width + ")";
    }
    public Point[] getVertices() {
        return this.vertices;
    }
    public String getColour(){
        return colour;
    }
    public int getWidth (){
        return  width;
    }
    public void setColour(String colour){
        this.colour = colour;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public  double length (){
        double length = 0;
        for (int i = 0; i < vertices.length - 1; i++){
            length += vertices[i].distance(vertices[i + 1]);
        }
        return length;
    }
    public void addLast (Point vertex) {
        Point[] h = new Point[this.vertices.length + 1];
        int i = 0;
        for (i = 0; i < this.vertices.length; i++) {
            h[i] = this.vertices[i];
        }
        h[i] = new Point(vertex);
        this.vertices = h;
    }
}