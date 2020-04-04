
/**
 * Information about number of rows, columns and each cell of the Matrix
 * @author Bahar Kaviani
 */
public class Matrix {
    private int row, column;
    private int[][] cell;

    /**
     * Constructor of Matrix class creates a matrix with "row" rows and "column" columns
     * @param row number of Matrix's rows
     * @param column number of Matrix's columns
     */
    public Matrix(int row, int column){
        this.row = row;
        this.column = column;
        cell = new int[row][column];
    }

    /**
     * Add second matrix with this matrix
     * If the function can't add two matrices will return this matrix
     * @param matrix second matrix
     * @return addition of this matrix and second matrix
     */
    public Matrix addMatrix(Matrix matrix){
        if (this.row == matrix.row && this.column == matrix.column){
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.column; j++) {
                    cell[i][j] += matrix.cell[i][j];
                }
            }
        }
        return this;
    }

    /**
     * Subtract second matrix from this matrix
     * If the function can't subtract second matrix from this matrix will return this matrix
     * @param matrix second matrix
     * @return subtraction of second matrix from this matrix
     */
    public Matrix subtractMatrix(Matrix matrix){
        if (this.row == matrix.row && this.column == matrix.column){
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.column; j++) {
                    cell[i][j] -= matrix.cell[i][j];
                }
            }
        }
        return this;
    }

    /**
     * Multiply second matrix to this matrix
     * If the function can't multiply second matrix to this matrix will return this matrix
     * @param matrix second matrix
     * @return multiplication of second matrix two this matrix
     */
    public Matrix multiplyMatrix(Matrix matrix){
        if (this.column == matrix.row){
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < matrix.column; j++) {
                    cell[i][j] = 0;
                    for (int k = 0; k < this.column; k++) {
                        cell[i][j] += cell[i][k] * matrix.cell[k][j];
                    }
                }
            }
        }
        return this;
    }

    /**
     * Print matrix in row and columns.
     */
    public void printMatrix(){
        for (int i = 0; i < this.row; i++) {
            System.out.print("|");
            for (int j = 0; j < this.column; j++) {
                System.out.format("%8d", cell[i][j]);
            }
            System.out.println("       |");
        }
    }

    /**
     * The function gets two number of rows and change them in a matrix
     * @param firstRow number of first row
     * @param secondRow number of second row
     */
    public void changeRows(int firstRow, int secondRow){
        int[] temp = new int[column];
        for (int j = 0; j < column; j++) {
            temp[j] = cell[firstRow][j];
            cell[firstRow][j] = cell[secondRow][j];
            cell[secondRow][j] = temp[j];
        }
    }

    /**
     * The function adds factors of two rows to the first row
     * @param firstRow number of first row
     * @param secondRow number of second row
     * @param factor the coefficient of second row
     */
    public void addFactorOfSecondRowToFirst(int firstRow, int secondRow, int factor){
        for (int j = 0; j < column; j++) {
            cell[firstRow][j] += (cell[secondRow][j] * factor);
        }
    }

    /**
     * The function multiplies each cell of rowNum's row by factor
     * @param rowNum number of row
     * @param factor the coefficient
     */
    public void factorOfRow(int rowNum, int factor){
        for (int j = 0; j < column; j++) {
            cell[rowNum][j] *= factor;
        }
    }

    /**
     * The function finds the pivot index of asked row
     * @param row number of asked row
     * @return the pivot index. It returns -1 if the row doesn't have pivot, in other words the row cells are all zero.
     */
    public int getPivotIndexOfRow(int row){
        for (int j = 0; j < column; j++) {
            if(cell[row][j] != 0)
                return j;
        }
        return -1;
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

    public int[][] getAllCells() {
        return cell;
    }

    public int getCell(int i, int j){
        return cell[i][j];
    }

}
