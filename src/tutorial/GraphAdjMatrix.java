package tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphAdjMatrix extends Graph {

    private Map<Integer, ArrayList<Integer>> adjListsMap;

    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        ArrayList<Integer> neighbors = new ArrayList<>();
        adjListsMap.put(v, neighbors);
    }

    @Override
    public void implementAddEdge(int v, int w) {
        (adjListsMap.get(v)).add(w);
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        // don't return adjListsMap.get(v)
        return new ArrayList<>(adjListsMap.get(v));
    }

//    public List<Integer> getDistance2(int v) {
//        List<Integer> twoHop = new ArrayList<>();
//        List<Integer> oneHop = adjListsMap.get(v);
//    }
}
