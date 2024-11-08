import java.util.Scanner;

public class MatrixMultiplication {

    /**
     * Helper method to handle user input for a matrix.
     * It prompts the user for the dimensions and elements of the matrix.
     *
     * @param rows The number of rows for the matrix.
     * @param cols The number of columns for the matrix.
     * @param matrixName The name of the matrix (A or B).
     * @return The matrix with the given dimensions filled with user input.
     */
    public static int[][] getMatrixInput(int rows, int cols, String matrixName) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter elements for " + matrixName + " matrix (" + rows + "x" + cols + "):");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    /**
     * Method to multiply two matrices A and B.
     *
     * @param matrixA The first matrix (A) with dimensions n x m.
     * @param matrixB The second matrix (B) with dimensions m x p.
     * @return The resulting matrix C of dimensions n x p after multiplication.
     */
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        // Perform matrix multiplication
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }

    /**
     * Method to display a matrix in formatted output.
     *
     * @param matrix The matrix to display.
     */
    public static void displayMatrix(int[][] matrix) {
        System.out.println("Matrix C:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Main method to execute the matrix multiplication program.
     * It handles user input for matrix dimensions and elements, performs multiplication, and displays the result.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input dimensions for matrix A
            System.out.print("Enter the number of rows for Matrix A: ");
            int rowsA = scanner.nextInt();
            System.out.print("Enter the number of columns for Matrix A: ");
            int colsA = scanner.nextInt();

            // Input dimensions for matrix B
            System.out.print("Enter the number of rows for Matrix B: ");
            int rowsB = scanner.nextInt();
            System.out.print("Enter the number of columns for Matrix B: ");
            int colsB = scanner.nextInt();

            // Check if matrix dimensions are compatible for multiplication
            if (colsA != rowsB) {
                System.out.println("Error: The number of columns in Matrix A must be equal to the number of rows in Matrix B for multiplication.");
                return;
            }

            // Get matrix A and matrix B from user
            int[][] matrixA = getMatrixInput(rowsA, colsA, "A");
            int[][] matrixB = getMatrixInput(rowsB, colsB, "B");

            // Perform matrix multiplication
            int[][] matrixC = multiplyMatrices(matrixA, matrixB);

            // Display the resulting matrix C
            displayMatrix(matrixC);

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter only integers for matrix elements and dimensions.");
        } finally {
            scanner.close();
        }
    }
}
