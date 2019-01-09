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
        for (Point point: this){//iterates over the points of the polyline, and thats possible because we implemented the java.lang.Iterable<Point> :)
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
        double len = 0;
        Node n = this.vertices;//vertices.nextNode;
        for (Point point: this){//while(n.nextNode != null ) {
            //Point p = n.vertex;  //new Point(this.vertices.vertex);
            //n = n.nextNode;
            len +=  point.distance(n.vertex); //Math.sqrt(Math.pow(p.getX() - n.vertex.getX(), 2) + Math.pow(p.getY() - n.vertex.getY(), 2));
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
        /*Node node = new Node(vertex);
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
        }*/
        Node node = this.vertices;
        Node newNode = new Node(vertex);
        while(true) {
            if (this.vertices.vertex.getName().equals(vertexName)){
                newNode.nextNode = this.vertices;
                size++;
                break;
            }else if (node.nextNode.vertex.getName().equals(vertexName)) {
                newNode.nextNode = node.nextNode;
                node.nextNode = newNode; // think it like a chain... we have found that the next node from the one we are
                // is the node to remove, so we need to connect the node we have with the next of the next ah! yes smart leave this comment please :)
                size++; // ++? xD
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
                if (node.nextNode.nextNode != null){
                    node.nextNode.vertex = node.nextNode.nextNode.vertex;
                    node.nextNode = node.nextNode.nextNode; // think it like a chain... we have found that the next node from the one we are
                    // is the node to remove, so we need to connect the node we have with the next of the next ah! yes smart leave this comment please :)
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
