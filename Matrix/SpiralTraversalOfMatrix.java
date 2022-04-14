package Matrix;

import java.util.Arrays;

public class SpiralTraversalOfMatrix extends MatrixParentClass {

    public static void main(String[] args) {

        int[][] matrix = get2DArray();

        // int[][] matrix = {
        // { 1, 2, 3, 4, 5 },
        // { 6, 7, 8, 9, 10 },
        // { 11, 12, 13, 14, 15 },
        // { 16, 17, 18, 19, 20 },
        // { 21, 22, 23, 24, 25 }
        // };

        // int[][] matrix = {
        // { 1, 2, 3, 4 },
        // { 5, 6, 7, 8 },
        // { 9, 10, 11, 12 },
        // { 13, 14, 15, 16 }
        // };

        printMatrix(matrix);

        // approachOne(matrix);

        approachTwo(matrix);
    }

    static void approachOne(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        System.out.println("\n\nSpiral Traversal of the Matrix is : ");

        if (rows == 1) {

            for (int i = 0; i < matrix[0].length; i++) {
                System.out.print(matrix[0][i] + "  ");
            }
            System.out.println("\n");
            return;
        } else if (columns == 1) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.print(matrix[i][0] + "  ");
            }
            System.out.println("\n");
            return;
        } else {
            // Calculate max traversal count based on if the minimum of rows, columns in
            // even or odd number
            int maxCount = Math.min(rows, columns) % 2 == 0 ? Math.min(rows, columns) / 2
                    : (Math.min(rows, columns) + 1);

            int i = 0, j = 0, k = 0, l = 0;

            for (int cnt = 0; cnt < maxCount; cnt++) {

                for (; j < columns - cnt; j++) {
                    System.out.print(matrix[i][j] + "  ");
                }

                i++;
                j--;

                for (; i < rows - cnt; i++) {
                    System.out.print(matrix[i][j] + "  ");
                }

                j--;
                i--;

                for (; j >= 0 + cnt; j--) {
                    System.out.print(matrix[i][j] + "  ");
                }

                j++;
                i--;

                for (; i > 0 + cnt; i--) {
                    System.out.print(matrix[i][j] + "  ");
                }

                i++;
                j++;
            } // for

            System.out.println("\n");
        }
    }

    static void approachTwo(int[][] matrix) {

        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;

        System.out.println("\n\nSpiral Traversal of the Matrix is : ");

        while (left <= right && top <= bottom) {

            for (int a = left; a <= right; a++) {
                System.out.print(matrix[top][a] + " ");
            }

            top++;

            for (int b = top; b <= bottom; b++) {
                System.out.print(matrix[b][right] + " ");
            }

            right--;

            for (int c = right; c >= left; c--) {
                System.out.print(matrix[bottom][c] + " ");
            }

            bottom--;
            for (int d = bottom; d >= top; d--) {
                System.out.print(matrix[d][left] + " ");
            }

            left++;

        }
        System.out.println("\n\n");
    }
}
