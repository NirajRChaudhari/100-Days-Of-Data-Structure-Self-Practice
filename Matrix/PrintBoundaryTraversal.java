package Matrix;

//Pattern Example : https://imgur.com/Rl2HrG2
public class PrintBoundaryTraversal extends MatrixParentClass {

    public static void main(String[] args) {

        int[][] matrix = get2DArray();

        System.out.println("\nBoundary Traversal of the Matrix :\n");

        if (matrix.length == 1) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[0][j] + "  ");
            }
            System.out.println("\n");

        } else if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.print(matrix[i][0] + "  ");
            }
            System.out.println("\n");

        } else {
            int i = 0, j = 0;
            for (; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }

            i++;
            j--;

            for (; i < matrix.length; i++) {
                System.out.print(matrix[i][j] + "  ");
            }

            i--;
            j--;

            for (; j >= 0; j--) {
                System.out.print(matrix[i][j] + "  ");
            }

            i--;
            j++;

            for (; i > 0; i--) {
                System.out.print(matrix[i][j] + "  ");
            }

            System.out.println("\n");

        }
    }
}
