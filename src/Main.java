import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matrix first = new Matrix(3, 5);
        Matrix second = new Matrix(3, 5);
        int[][] cell = new int[3][5];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                cell[i][j] = scanner.nextInt();
            }
        }

        first.setCell(cell);

        first.printMatrix();
        second.printMatrix();
    }
}
