import java.util.Scanner;

/**
 * Information about a System of linear equation
 * @author Bahar Kaviani
 */
public class SystemOfLinearEquation {
    private Matrix coefficient, constant, augmented;


    /**
     * Constructor of SystemOfLinearEquation creates the coefficient and constant matrices
     */
    public SystemOfLinearEquation() {
        Scanner scanner = new Scanner(System.in);

        // set the row and column of coefficient matrix
        System.out.println("Enter the row and column of the coefficient matrix:");
        coefficient = new Matrix(scanner.nextInt(), scanner.nextInt());

        // set each cell of coefficient matrix
        System.out.println("Enter each cell of the coefficient matrix:");
        int[][] cell = new int[coefficient.getRow()][coefficient.getColumn()];
        for (int i = 0; i < coefficient.getRow(); i++) {
            for (int j = 0; j < coefficient.getColumn(); j++) {
                cell[i][j] = scanner.nextInt();
            }
        }
        coefficient.setCell(cell);

        // set the row and column of constant matrix
        constant = new Matrix(coefficient.getRow(), 1);

        // set each cell of constant matrix
        System.out.println("Enter each constant:");
        int[][] cell2 = new int[constant.getRow()][constant.getColumn()];
        for (int i = 0; i < constant.getRow(); i++) {
            for (int j = 0; j < constant.getColumn(); j++) {
                cell2[i][j] = scanner.nextInt();
            }
        }
        constant.setCell(cell2);
    }


    public Matrix getAugmented() {
        return augmented;
    }

    /**
     *
     */
    public void setAugmented() {
        augmented = new Matrix(coefficient.getRow(), (coefficient.getColumn() + 1));
        int[][] cell = new int[augmented.getRow()][augmented.getColumn()];
        for (int i = 0; i < augmented.getRow(); i++) {
            int j;
            for (j = 0; j < augmented.getColumn() - 1; j++) {
                cell[i][j] = coefficient.getCell()[i][j];
            }
            cell[i][j] = constant.getCell()[i][0];
        }
        augmented.setCell(cell);
    }

    public Matrix getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Matrix coefficient) {
        this.coefficient = coefficient;
    }

    public Matrix getConstant() {
        return constant;
    }

    public void setConstant(Matrix constant) {
        this.constant = constant;
    }
}
