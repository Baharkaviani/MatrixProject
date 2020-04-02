import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matrix first = new Matrix(3, 5);
        Matrix second = new Matrix(3, 5);
        SystemOfLinearEquation system = new SystemOfLinearEquation();

        System.out.println("coefficient");
        system.getCoefficient().printMatrix();
        System.out.println("constant");
        system.getConstant().printMatrix();
    }
}
