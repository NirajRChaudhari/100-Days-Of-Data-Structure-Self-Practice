package Arrays;

import java.util.Scanner;

//Common Array Methods and Variables are declared here and this class is imported in all codes below
class ArrayParentClass {
    protected static Scanner sc = new Scanner(System.in);

    protected static int[] getArray() {
        System.out.println("Please enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the values of the array: ");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        return array;
    }

    protected static void printArray(int[] array, int size) {

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }

    protected static void swap(int[] array, int a, int b) {
        array[a] = array[a] + array[b];
        array[b] = array[a] - array[b];
        array[a] = array[a] - array[b];
    }
}
