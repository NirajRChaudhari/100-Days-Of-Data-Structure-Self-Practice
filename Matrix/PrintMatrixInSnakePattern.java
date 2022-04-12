package Matrix;

//Pattern Example : https://imgur.com/w8C5FMF
public class PrintMatrixInSnakePattern extends MatrixParentClass {

    public static void main(String[] args) {

        int[][] matrix = get2DArray();

        System.out.println("\nMatrix in Snake Pattern : \n");

        for (int i = 0; i < matrix.length; i++) {

            // Print Left to Rsight
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + "  ");
                }
            }
            // Print Right to Left
            else {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j] + "  ");
                }
            }
        }
        System.out.println("\n");
    }
}
