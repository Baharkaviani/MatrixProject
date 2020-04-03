import java.util.Scanner;

/**
 * Information about a System of linear equation
 * @author Bahar Kaviani
 */
public class SystemOfLinearEquation {
    private Matrix coefficient, constant, augmented, REFmatrix;
    private int pivotNum;


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

    /**
     * Create echelon form of augmented matrix with row equivalent operations
     */
    public void findREFmatrix(){
        REFmatrix = new Matrix(augmented.getRow(), augmented.getColumn());
        REFmatrix.setCell(augmented.getAllCells());

        pivotNum = 0;

        for (int j = 0; j < REFmatrix.getColumn(); j++) {
            // find the j_th pivot
            for (int i = pivotNum; i < REFmatrix.getRow(); i++) {
                // check if i_th row in the j_th column has pivot
                // set the first i_th row with non_zero cell as a first row
                if(REFmatrix.getAllCells()[i][j] != 0) {
                    //change the i_th row with pivotNum_th row if they're different rows
                    if(i != pivotNum) {
                        REFmatrix.changeRows(i, pivotNum);
                        System.out.println("---------------------------");
                        System.out.println("change row" + pivotNum + " with row" + i);
                        REFmatrix.printMatrix();
                    }
                    // we find the pivot
                    pivotNum++;
                    break;
                }
            }
            // ok! we found the pivot of pivotNum_th row
            // now we need to change all cells under the new pivot to zero...
            for (int i = pivotNum; i < REFmatrix.getRow(); i++) {
                if(REFmatrix.getCell(i, j) != 0){
                    // find the Lowest common multiple of two rows
                    int LCM = lcm(REFmatrix.getCell(pivotNum - 1, j), REFmatrix.getCell(i, j));

                    // find the coefficient of pivot row
                    int pivotCoefficient = LCM / Math.abs(REFmatrix.getCell(pivotNum - 1, j)) ;

                    // find the coefficient of i_th row
                    int coefficient;
                    if(REFmatrix.getCell(pivotNum - 1, j) * REFmatrix.getCell(i, j) > 0)
                        coefficient = - LCM / Math.abs(REFmatrix.getCell(i, j));
                    else
                        coefficient = LCM / Math.abs(REFmatrix.getCell(i, j));

                    // now multiply the rows by  their coefficient
                    REFmatrix.factorOfRow(i, coefficient);

                    // and add pivotCoefficient of pivot row to that row
                    REFmatrix.addFactorOfSecondRowToFirst(i, pivotNum - 1, pivotCoefficient);
                    System.out.println("---------------------------");
                    System.out.print("replace row" + i + " by ");
                    System.out.println(pivotCoefficient + "row" + (pivotNum - 1) + " + " + coefficient + "row" + i);
                    REFmatrix.printMatrix();
                }
            }
        }
    }

    /**
     * The function finds the Lowest common multiple of two numbers
     * @param number1 first number
     * @param number2 second number
     * @return absolute value of lcm of two numbers
     */
    public static int lcm(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        int absNumber1 = Math.abs(number1);
        int absNumber2 = Math.abs(number2);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }

    public Matrix getAugmented() {
        return augmented;
    }

    /**
     * Make augmented matrix based on coefficient and constant matrices
     */
    public void setAugmented() {
        augmented = new Matrix(coefficient.getRow(), (coefficient.getColumn() + 1));
        int[][] cell = new int[augmented.getRow()][augmented.getColumn()];
        for (int i = 0; i < augmented.getRow(); i++) {
            int j;
            for (j = 0; j < augmented.getColumn() - 1; j++) {
                cell[i][j] = coefficient.getAllCells()[i][j];
            }
            cell[i][j] = constant.getAllCells()[i][0];
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
