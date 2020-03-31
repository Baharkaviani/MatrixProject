/**
 * matrix information of each cell
 * @author Bahar Kaviani
 */
public class Matrix {
    private int row, column;
    private int[][] cell;

    public Matrix(int row, int column){
        this.row = row;
        this.column = column;
        cell = new int[row][column];
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setCell(int[][] cell) {
        this.cell = cell;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int[][] getCell() {
        return cell;
    }

}
