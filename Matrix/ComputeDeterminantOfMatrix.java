package Matrix;

public class ComputeDeterminantOfMatrix extends MatrixParentClass {

    public static void main(String[] args) {

        int[][] matrix = get2DArray();

        System.out.println("\nThe Determinant of the given Matrix is : " + computeDeterminantOfMatrix(matrix));
    }

    static int computeDeterminantOfMatrix(int[][] matrix) {

        int determinant = 0;

        if (matrix.length == 2 && matrix[0].length == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            determinant = determinant
                    + (((int) Math.pow(-1, i + 2)) * matrix[0][i]
                            * computeDeterminantOfMatrix(populateMatrixWithoutCurrentRowAndColumn(matrix, 0, i)));

        }

        return determinant;
    }

    static int[][] populateMatrixWithoutCurrentRowAndColumn(int[][] matrix, int rowNumber, int columnNumber) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] newMatrix = new int[rows - 1][columns - 1];

        for (int i = 0, k = 0; i < rows; i++, k++) {

            if (i == rowNumber) {
                k--;
                continue;
            }

            for (int j = 0, l = 0; j < columns; j++, l++) {

                if (j == columnNumber) {
                    l--;
                    continue;
                }

                newMatrix[k][l] = matrix[i][j];
            }
        }

        return newMatrix;
    }
}
