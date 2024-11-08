import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for matrix A
        System.out.print("Enter the number of rows and columns for Matrix A (e.g., 2 3): ");
        int n = scanner.nextInt(); // Number of rows in Matrix A
        int m = scanner.nextInt(); // Number of columns in Matrix A

        int[][] A = new int[n][m];
        System.out.println("Enter the elements of Matrix A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        // Input for matrix B
        System.out.print("Enter the number of rows and columns for Matrix B (e.g., 3 2): ");
        m = scanner.nextInt(); // Number of rows in Matrix B (should match columns of A)
        int p = scanner.nextInt(); // Number of columns in Matrix B

        int[][] B = new int[m][p];
        System.out.println("Enter the elements of Matrix B:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                B[i][j] = scanner.nextInt();
            }
        }

        // Matrix multiplication result
        int[][] C = new int[n][p];

        // Performing matrix multiplication
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                C[i][j] = 0;  // Initialize element to 0 before summing
                for (int k = 0; k < m; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Output the resulting matrix C
        System.out.println("Matrix C (Result of A * B):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
