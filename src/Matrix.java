
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
                System.out.format("%5d", cell[i][j]);
            }
            System.out.println("    |");
        }
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
