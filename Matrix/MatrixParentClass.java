package Matrix;

import java.util.Scanner;

public class MatrixParentClass {

    static Scanner sc = new Scanner(System.in);

    static int[][] get2DArray() {

        System.out.println("\nEnter no. of Rows in 2d array : ");
        int rows = sc.nextInt();

        System.out.println("\nEnter no. of Columns in the 2d array : ");
        int columns = sc.nextInt();

        int[][] array = new int[rows][columns];

        System.out.println("\nEnter the Data of 2D Array : \n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                System.out.print("(" + i + "," + j + ") : ");
                array[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        return array;
    }

    static void printMatrix(int[][] array) {

        System.out.println("\nData in the Matrix is : \n");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(String.format("%-5d", array[i][j]));
            }
            System.out.println();
        }
    }

    static void swap(int[][] array, int row1, int column1, int row2, int column2) {

        array[row1][column1] = array[row1][column1] + array[row2][column2];
        array[row2][column2] = array[row1][column1] - array[row2][column2];
        array[row1][column1] = array[row1][column1] - array[row2][column2];
    }
}
