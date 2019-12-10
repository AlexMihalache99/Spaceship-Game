/**
 * This class represents the position of various entities and cells.
 * @author William Bampton
 */
public class Position{
    private int row;
    private int col;

    /**
     * Create a new position.
     * @param row The row.
     * @param col The column.
     */
    public Position (int row, int col){
        this.row = row;
        this.col = col;
    }

    /**
     * Get the row of the position.
     * @return The row.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Set the row of the position.
     * @param row The row.
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Set the column of the position.
     * @param col The column.
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Get the column of the position.
     * @return The column.
     */
    public int getCol() {
        return this.col;
    }
}
