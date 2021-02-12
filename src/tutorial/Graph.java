package tutorial;

import java.util.List;

public abstract class Graph {

    private int numVertices;
    private int numEdges;

    public Graph() {
        this.numVertices = 0;
        this.numEdges = 0;
    }

    public void addVertex() {
        implementAddVertex();
        numVertices++;
    }

    public abstract void implementAddVertex();


    public abstract List<Integer> getNeighbors(int v);

    public abstract void implementAddEdge(int v, int w);

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void setNumEdges(int numEdges) {
        this.numEdges = numEdges;
    }
}
