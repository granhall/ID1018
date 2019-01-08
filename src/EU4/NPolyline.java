package EU4;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NPolyline implements Polyline {
    int size = 0;
    private static class Node {
        public Point vertex ;

        public Node nextNode ;

        public Node ( Point vertex ) {
            this.vertex = vertex ;
            nextNode = null ;
        }
    }

    private Node vertices ;
    private String colour = " black ";
    private int width = 1; // pixels
    public NPolyline () {this.vertices = null ;
    }

    public NPolyline ( Point [] vertices ) {
        if ( vertices . length > 0) {
            Node node = new Node (new Point ( vertices [0]));
            this.vertices = node ;
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
    public Point[] getVertices(){
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
        Node n = this.vertices;//vertices.nextNode;
        while(n != null ) {
            Point p = n.vertex;  //new Point(this.vertices.vertex);
            n = n.nextNode;
            len += Math.sqrt(Math.pow(p.getX() - n.vertex.getX(), 2) + Math.pow(p.getY() - n.vertex.getY(), 2));
            //p = n.vertex;


        }
        return len;
    }
    private static double distanceBetweenVertices(Point p1, Point p2){
        double vectorX = Math.pow(p2.getX()-p1.getX(),2);
        double vectorY = Math.pow(p2.getY()-p1.getY(),2);
        return Math.sqrt(vectorX + vectorY);
    }
    public void add(Point vertex){
        Node node = new Node(vertex);
        if (this.vertices == null) {
            this.vertices = node;
        }
        Node q = this.vertices;
        while (q.nextNode != null){
            q = q.nextNode;
        }
        q.nextNode = node;
        size++;
    }
    public void insertBefore(Point vertex, String vertexName)throws NoSuchElementException {
    Node node = new Node(vertex);
    if (this.vertices.vertex.getName().equals(vertexName)){
        node.nextNode = this.vertices;
        this.vertices = node;
    }
    Node n = this.vertices;
    boolean has = false;
    while (n.nextNode != null){
        if (n.nextNode.vertex.getName().equals(vertexName)){
            node.nextNode = n.nextNode;
            n.nextNode = n;
            has = true;
            n = n.nextNode;
        }
        n = n.nextNode;
    }
    size++;
    if (!has){
        throw new NoSuchElementException("None found");
    }
    }
    public void remove(String vertexName)throws NoSuchElementException {
        Node n = this.vertices;
        boolean has = false;
        if (this.vertices.vertex.getName().equals(vertexName)){
            this.vertices = this.vertices.nextNode;
        }
        while (n != null){
            if (n.vertex.getName().equals(vertexName)){
                n = n.nextNode;
                has = true;
                size--;
            }
            n = n.nextNode;
        }
        if(!has){
            throw new NoSuchElementException("None found");
        }
    }
    public Iterator<Point> iterator(){
        return new Iterator<Point>() {
            Node node = vertices;
            int pos = 0;
            private int findLength(){
                Node current = vertices;
                int result = 0;
                while (current != null){
                    result++;
                    current = current.nextNode;
                }
                return result;
            }
            int length = findLength();
            public boolean hasNext() {
                return pos < length;
            }
            public Point next() {
                if (hasNext()){
                    pos++;
                    Point result = node.vertex;
                    node = node.nextNode;
                    return result;
                }
                return node.vertex;
            }
        };
    }
}
