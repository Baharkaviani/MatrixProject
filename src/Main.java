
public class Main {
    public static void main(String[] args) {
        // create a new system of linear equation
        SystemOfLinearEquation system = new SystemOfLinearEquation();

        // print coefficient and constant matrices
        System.out.println("coefficient");
        system.getCoefficient().printMatrix();
        System.out.println("constant");
        system.getConstant().printMatrix();

        // make and print augmented matrix
        system.setAugmented();
        System.out.println("augmented");
        system.getAugmented().printMatrix();

        system.findREFmatrix();

        // the findAnswer function is not ocmplete. It just can understand if the system is inconsistent.
        system.findAnswer();
    }
}
