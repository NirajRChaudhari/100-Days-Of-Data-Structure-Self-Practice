package Matrix;

public class SearchNumberInRowAndColumnwiseSortedArray extends MatrixParentClass {

    public static void main(String[] args) {

        // int[][] matrix = get2DArray();

        int[][] matrix = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };

        printMatrix(matrix);

        System.out.println("\nEnter the number to be searched :");
        int key = sc.nextInt();

        approachOne(matrix, key);
    }

    static void approachOne(int[][] matrix, int key) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        int i = 0, j = columns - 1;

        while (i < rows && j >= 0) {

            if (matrix[i][j] == key) {
                System.out.println("\nIndex of " + key + " in the array is :(" + i + "," + j + ")\n");

                return;
            }

            if (key < matrix[i][j]) {
                j--;

            } else {
                i++;
            }
        }

        System.out.println("\nNumber " + key + " is NOT present in the array");
    }
}
