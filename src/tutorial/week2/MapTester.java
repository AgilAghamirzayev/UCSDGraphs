package tutorial.week2;

import geography.GeographicPoint;
import roadgraph.MapGraph;
import util.GraphLoader;

import java.util.List;

public class MapTester {
    public static void main(String[] args) {
        System.out.println("Making a new map...");
        MapGraph theMap = new MapGraph();
        System.out.println("DONE. \nLoading the map... ");

        GraphLoader.loadRoadMap("data/testdata/simpletest.map", theMap);

        System.out.println("DONE.");

        System.out.println("Num nodes: " + theMap.getVertices());
        System.out.println("Num edges: " + theMap.getNumEdges());

        List<GeographicPoint> route = theMap.bfs(new GeographicPoint(1.0,1.0), new GeographicPoint(8.0, -1.0));
        System.out.println(route);

    }
}
