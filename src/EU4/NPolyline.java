package EU4;
import java.util.Iterator;
public class NPolyline implements Polyline {
    private static class Node {
        public Point vertex ;
        public Node nextNode ;
        public Node ( Point vertex ) {
            this . vertex = vertex ;
            nextNode = null ;
        }
    }
    int size = 0;
    private Node vertices ;
    private String colour = " black ";
    private int width = 1; // pixels
    public NPolyline () {
        this . vertices = null ;
    }
    public NPolyline ( Point [] vertices ) {
        if ( vertices . length > 0) {
            Node node = new Node ( new Point ( vertices [0]));
            this . vertices = node ;
            size++;
            int pos = 1;
            while (pos < vertices . length ) {
                node . nextNode = new Node ( new Point ( vertices [ pos ++]));
                node = node.nextNode;
                size++;
            }
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node n = this.vertices;
        while (n != null){
            sb.append("(" + n.vertex.getName() + " , " + n.vertex.getX() + " , " + n.vertex.getY() + ")");
            n = n.nextNode;
        }
        sb.append("," + this.getWidth() + " , " + this.getColour() + " | length: " + this.length());
        return sb.toString();
    }
    public Point[] getVerticies(){
        Point[] gvertices = new Point[size];
        int i = 0;
        Node n = this.vertices;
        while (n != null){
            gvertices[i] = n.vertex;
            n = n.nextNode;
        }
        return gvertices;
    }
    public String getColour(){
        return this.colour;
    }
    public int getWidth(){
        return this.width;
    }
    public void setColour (String colour){
        this.colour = colour;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public double length() {
        double len = 0;
        Node n = this.vertices;
        Point p = new Point(this.vertices.vertex);
        while (n != null){
            len += n.vertex.distance(p)
        }

    }
}
