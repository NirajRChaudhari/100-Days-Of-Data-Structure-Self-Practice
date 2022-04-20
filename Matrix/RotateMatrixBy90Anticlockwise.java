package Matrix;

public class RotateMatrixBy90Anticlockwise extends MatrixParentClass {

    public static void main(String[] args) {

        int[][] matrix = get2DArray();
        printMatrix(matrix);

        // Time Complexity O(N^2) and Space Complexity O(N^2)
        naiveRotateMatrix(matrix);

        // Time Complexity O(N^2) and Space Complexity O(N) Constant space
        // efficientRotateMatrix(matrix);
    }

    static void naiveRotateMatrix(int[][] matrix) {

        // Handle single row or single column case

        int[][] rotatedMatrix = new int[matrix[0].length][matrix.length];

        int rows = matrix.length;
        int columns = matrix[0].length;

        if (rows == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                rotatedMatrix[i][0] = matrix[0][i];
            }

        } else if (columns == 1) {
            for (int i = 0; i < matrix.length; i++) {
                rotatedMatrix[0][i] = matrix[i][0];
            }

        } else {
            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < columns; j++) {

                    rotatedMatrix[rows - 1 - j][i] = matrix[i][j];
                }
            }

        }

        System.out.println("\n\nPerformed 90 Degree Anticlockwise Rotation");
        printMatrix(rotatedMatrix);
    }

    static void efficientRotateMatrix(int[][] matrix) {

        int rows = matrix.length;

        // Take a transpose of the Matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // Swap Rows
        for (int i = 0; i < matrix.length / 2; i++) {

            for (int j = 0; j < matrix.length; j++) {

                swap(matrix, i, j, matrix.length - 1 - i, j);
            }
        }

        System.out.println("\n\nPerformed 90 Degree Anticlockwise Rotation");
        printMatrix(matrix);
    }
}
