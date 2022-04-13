package Matrix;

public class PrintTransposeOfMatrix extends MatrixParentClass {

    public static void main(String[] args) {

        int[][] matrix = get2DArray();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {

                // Swap 2 elements
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];

            }
        } // for

        printMatrix(matrix);
    }
}
