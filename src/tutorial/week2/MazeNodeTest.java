package tutorial.week2;

import week3example.MazeNode;

import java.util.LinkedList;
import java.util.List;

public class MazeNodeTest {

    private List<MazeNodeTest> neighbors;

    private int row;
    private int column;
    private char displayChar;

    public static final char EMPTY = '-';
    public static final char PATH = 'o';
    public static final char START = 'S';
    public static final char GOAL = 'G';

    /**
    * @return the displayChar
    */
    public char getDisplayChar() {return displayChar;}

    /**
     * @param displayChar the display char to set
     */
    public void setDisplayChar(char displayChar) {
        this.displayChar = displayChar;
    }

    public MazeNodeTest(int row, int column) {
        this.row = row;
        this.column = column;
        neighbors = new LinkedList<>();
        displayChar = EMPTY;
    }

    /**
     * @param neighbour to add neighbours
     */
    public void  addNeighbor(MazeNodeTest neighbour) {
        neighbors.add(neighbour);
    }

    /**
     *
     * @return the neighbours
     */
    public List<MazeNodeTest> getNeighbors() {
        return neighbors;
    }

    /**
     *
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @return the column
     */

    public int getColumn() {
        return column;
    }
}
