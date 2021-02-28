package tutorial.week1;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjMatrixArray extends Graph {

    private int[][] adjMatrix;

    @Override
    public void implementAddEdge(int v, int w) {
        adjMatrix[v][w] = 1;

    }
//
//    @Override
//    public void implementAddVertex() {
//        int v = getNumVertices();
//        if (v >= adjMatrix.length) {
//            int[][] newAdjMatrix = new int[v * 2][v * 2];
//            for (int i = 0; i < adjMatrix.length; i++) {
//                System.arraycopy(adjMatrix[i], 0, newAdjMatrix[i], 0, adjMatrix.length);
//            }
//            adjMatrix = newAdjMatrix;
//        }
//        Arrays.fill(adjMatrix[v], 0);
//    }

    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        if (v >= adjMatrix.length) {
            int[][] newAdjMatrix = new int[v * 2][v * 2];
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    newAdjMatrix[i][j] = adjMatrix[i][j];
                }
            }
            adjMatrix = newAdjMatrix;
        }
        for (int i = 0; i < adjMatrix[v].length; i++) {
            adjMatrix[v][i] = 0;
        }
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < getNumVertices(); i++) {
            for (int j = 0; j < adjMatrix[v][i]; j++) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    public List<Integer> getDistance2(int v) {
        List<Integer> twoHop = new ArrayList<>();
        for (int i = 0; i < getNumVertices(); i++) {
            for (int j = 0; j < adjMatrix[v][i]; j++) {
                twoHop.add(adjMatrix[v][i]);
            }
        }
        return twoHop;
    }
}
