package Arrays;

import java.util.Scanner;

public class CheckIfArrayIsSorted extends ArrayParentClass {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int array[] = getArray();

        System.out.println("\n\nProcessing ...\n");

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                System.out.println("Array is NOT Sorted\n");
                return;
            }
        }

        System.out.println("Array is Sorted\n");
    }
}
