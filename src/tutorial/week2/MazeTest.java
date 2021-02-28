package tutorial.week2;

import java.util.*;

public class MazeTest {

    private MazeNodeTest[][] cells;
    private int width;
    private int height;

    private final int DEFAULT_SIZE = 10;

    public MazeTest() {
        cells = new MazeNodeTest[DEFAULT_SIZE][DEFAULT_SIZE];
        this.width = DEFAULT_SIZE;
        this.height = DEFAULT_SIZE;
    }

    public MazeTest(int width, int height) {
        cells = new MazeNodeTest[height][width];
        this.width = width;
        this.height = height;
    }

    /**
     * Reset the maze to have the given height and width
     *
     * @param width  The width  of the maze
     * @param height The height of the maze
     */
    public void initialize(int width, int height) {
        cells = new MazeNodeTest[height][height];
        this.width = width;
        this.height = height;
    }

    /**
     * Add a graph node (i.e not a wall) at the given location
     * Any grid entry doesn't contain a node is interpreted as a wall
     *
     * @param currRow The row where the node exists
     * @param currCol The column where the node exists
     */
    public void addNode(int currRow, int currCol) {
        cells[currRow][currCol] = new MazeNodeTest(currRow, currCol);
    }

    /**
     * Link the nodes that are adjacent (and not null) to each other with an edge.
     * There is an edge between any two adjacent nodes up, down, left or right
     */
    public void linkEdges() {
        int numRows = cells.length;
        for (int row = 0; row < numRows; row++) {
            int numCols = cells[row].length;
            for (int col = 0; col < numCols; col++) {
                if (cells[row][col] != null) {
                    if (row > 0 && cells[row - 1][col] != null) {
                        cells[row][col].addNeighbor(cells[row - 1][col]);
                    }
                    if (col > 0 && cells[row][col - 1] != null) {
                        cells[row][col].addNeighbor(cells[row][col-1]);
                    }
                    if (row < numRows -1 && cells[row + 1][col] != null) {
                        cells[row][col].addNeighbor(cells[row + 1][col]);
                    }
                    if (col < numCols - 1 && cells[row][col + 1] != null) {
                        cells[row][col].addNeighbor(cells[row][col + 1]);
                    }
                }
            }
        }
    }

    /**
     * print the maze grid to the screen
     */
    public void printMaze() {
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (cells[r][c] == null) {
                    System.out.print('*');
                } else {
                    System.out.print(cells[r][c].getDisplayChar());
                }
            }
            System.out.print("\n");
        }
    }

    /**
     * Change the display of the maze so that it will print the path
     * found from start to goal.
     *
     * NOTE: This method could use redesigning so that it did not expose
     * the MazeNodeTest class to the outside world.
     *
     * @param path A path of MazeNodeTest from start goal.
     */

    public void setPath(List<MazeNodeTest> path) {
        int index = 0;
        for (MazeNodeTest n: path) {
            if (index == 0) {
                n.setDisplayChar(MazeNodeTest.START);
            } else if (index == path.size() - 1) {
                n.setDisplayChar(MazeNodeTest.GOAL);
            } else {
                n.setDisplayChar(MazeNodeTest.PATH);
            }
            index++;
        }
    }

    /**
     * Clear (reset) the maze so that it will not display a path
     * from start to goal.
     */

    public void clearPath() {
        for (MazeNodeTest[] cell : cells) {
            for (MazeNodeTest n : cell) {
                if (n != null) {
                    n.setDisplayChar(MazeNodeTest.EMPTY);
                }
            }
        }
    }

    public List<MazeNodeTest> dfs(int startRow, int startCol, int endRow, int endCol) {
        MazeNodeTest start = cells[startRow][startCol];
        MazeNodeTest goal = cells[endRow][endCol];

        if (start == null || goal == null) {
            System.out.println("Start or goal node is null! No path exists.");
            return new LinkedList<>();
        }

        HashMap<MazeNodeTest, MazeNodeTest> parentMap = new HashMap<>();
        boolean b = dfsSearch(start, goal, parentMap);
        HashSet<MazeNodeTest> visited = new HashSet<>();
        Stack<MazeNodeTest> toExplore = new Stack<>();
        toExplore.push(start);
        boolean found = false;

        // Do the search
        while (!toExplore.isEmpty()) {
            MazeNodeTest curr = toExplore.pop();
            if (curr == goal) {
                found = true;
                break;
            }
            List<MazeNodeTest> neighbors = curr.getNeighbors();
            ListIterator<MazeNodeTest> it = neighbors.listIterator(neighbors.size());
            while (it.hasPrevious()) {
                MazeNodeTest next = it.previous();
                if (!visited.contains(next)) {
                    visited.add(next);
                    parentMap.put(next, curr);
                    toExplore.push(next);
                }
            }
        }

        if (!found) {
            System.out.println("No path exists");
            return new LinkedList<>();
        }

        // reconstruct the path
        LinkedList<MazeNodeTest> path = new LinkedList<>();
        MazeNodeTest curr = goal;
        while (curr != start) {
            path.addFirst(curr);
            curr = parentMap.get(curr);
        }

        path.addFirst(curr);
        return path;
    }

    private static boolean dfsSearch(MazeNodeTest start, MazeNodeTest goal,
                                     HashMap<MazeNodeTest, MazeNodeTest> parentMap) {
     return  true;
    }



}
