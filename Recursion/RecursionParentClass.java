package Recursion;

import java.util.Scanner;

public class RecursionParentClass {

    static Scanner sc = new Scanner(System.in);

    static int getNumber() {
        System.out.println("\nEnter the Number : ");
        return sc.nextInt();
    }

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
}
