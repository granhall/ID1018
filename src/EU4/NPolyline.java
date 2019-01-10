package EU4;
import java.util.Iterator;
import java.util.NoSuchElementException;
@SuppressWarnings("Duplicates")

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
        for (Point point: this){ //iterates over the points of the polyline, and thats possible since java.lang.Iterable<Point> is implenmented from interface
            sb.append("(" + point.getName() + " , " + point.getX() + " , " + point.getY() + ")");
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
        Node n = this.vertices;
        double len = 0;
        for (Point point: this){ //iterates over polyline
            len +=  point.distance(n.vertex);
        }
        return len;
    }

    private static double distanceBetweenVertices(Point p1, Point p2){
        double vectorX = Math.pow(p2.getX()-p1.getX(),2);
        double vectorY = Math.pow(p2.getY()-p1.getY(),2);
        return Math.sqrt(vectorX + vectorY);
    }
    public void add(Point vertex){

        if (this.vertices == null) {
            this.vertices = new Node(vertex);
        }
        Node q = this.vertices;
        while(true) {
            if (q.nextNode != null) {
                q = q.nextNode;
            }else{
                q.nextNode = new Node(vertex);
                break;
            }
        }
        size++;
    }
    public void insertBefore(Point vertex, String vertexName)throws NoSuchElementException {
        Node node = this.vertices;
        Node newNode = new Node(vertex);
        while(true) {
            if (this.vertices.vertex.getName().equals(vertexName)){
                newNode.nextNode = this.vertices;
                size++;
                break;
            }else if (node.nextNode.vertex.getName().equals(vertexName)) {
                newNode.nextNode = node.nextNode;
                node.nextNode = newNode; // chain... found that the next node from the one we are on is the 'before'
                // need to connect the node we have with the next of the next
                size++;
                break;
            }else if(node.nextNode != null){
                node = node.nextNode;
            }else{
                throw new NoSuchElementException("None found");
            }
        }
    }
    public void remove(String vertexName)throws NoSuchElementException {
        Node node = this.vertices;
        while(true) {
            if (this.vertices.vertex.getName().equals(vertexName)){
                this.vertices = null;
                size--;
                break;
            }else if (node.nextNode.vertex.getName().equals(vertexName)) {
                if (node.nextNode.nextNode != null){ //checks that it is not the last in the list
                    node.nextNode.vertex = node.nextNode.nextNode.vertex;
                    node.nextNode = node.nextNode.nextNode; //
                    // node to remove, need to connect the node with the next of the next
                }else{
                    node.nextNode = null;
                }
                size--;
                break;
            }else if(node.nextNode != null){
                node = node.nextNode;
            }else{
                throw new NoSuchElementException("None found");
            }
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
