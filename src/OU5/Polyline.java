package OU5;
@SuppressWarnings("Duplicates")
public class Polyline {
    private Point[] vertices;
    private String colour = "black";
    private int width = 1;

    public Polyline() {
        this.vertices = new Point[0];
    }

    public Polyline(Point[] vertices) {
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

    public Point[] getVertices() { // Unsure about this
        Point[] gvertices = new Point[vertices.length];
        for (int i = 0; i < this.vertices.length; i++) {
            gvertices[i] = new Point(vertices[i]);
        }
        return gvertices;
    }

    public String getColour() {
        return colour;
    }

    public int getWidth() {
        return width;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double length() {
        double length = 0;
        for (int i = 0; i < vertices.length - 1; i++) {
            length += vertices[i].distance(vertices[i + 1]);
        }
        return length;
    }

    public void addLast(Point vertex) {
        Point[] h = new Point[this.vertices.length + 1];
        int i = 0;
        for (i = 0; i < this.vertices.length; i++) {
            h[i] = this.vertices[i];
        }
        h[i] = new Point(vertex);
        this.vertices = h;
    }

    public void addBefore(Point vertex, String vertexName) {
        Point refvertex = new Point(vertex); // copying in order for code to use a reference to parameter instead of parameter itself
        Point[] newArray = new Point[vertices.length + 1]; // new array one slot larger
        int current = 0;
        for (int i = 0; i < this.vertices.length; i++) {
            if (this.vertices[i].getName().equals(vertexName)) {
                current = i; //Find position of where the new point should be added
                break;
            }
        }
        newArray[current] = refvertex; //set the point at position current to new vertex provided
        for (int i = 0; i < newArray.length - 1; i++) {
            newArray[i < current ? i : i + 1] = this.vertices[i]; // This skips the position current with the selector.

        }
        this.vertices = newArray; // creates new reference to the array with the vertex added.
    }

    public void remove(String vertexName) {
        Point[] newArray = new Point[vertices.length - 1];
        int current = 0;
        for (int i = 0; i < this.vertices.length; i++) {
            if (this.vertices[i].getName().equals(vertexName)) {
                current = i;
                break;
            }
        }
        for (int i = 0; i < current; i++) { // copies values of this.vertices up to but not including the removed index 'current'
            newArray[i] = this.vertices[i];
        }
        for (int i = current; i < newArray.length; i++) { // continues copying values until end of array length but values jump over removed index
            newArray[i] = this.vertices[i + 1];
        }

        this.vertices = newArray; // creates new reference to the array with the vertex removed.
    }

    public class PolylineIterator {
        private int current = -1;

        public PolylineIterator(){
            if (Polyline.this.vertices.length > 0) {
                current = 0;
            }
        }

        public boolean hasVertex() {
            return current != -1;
        }
        public Point vertex () throws java.util.NoSuchElementException {
            if (!this.hasVertex()) {
                throw new java.util.NoSuchElementException("End of Iteration");
                Point vertex = new Polyline.this.vertices[current]; //TODO fix this?
                return vertex;
            }
        }
        public void advance () {
            if (current >= 0 && current < Polyline.this.vertices.length -1) {
                current++;
            } else {
                current = -1;
            }
        }
    }

}
