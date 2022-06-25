package Searching;

import java.util.Scanner;

public class SearchingParentClass {

    static Scanner sc = new Scanner(System.in);

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

    static int getNumber() {
        System.out.println("\nEnter the number to be searched : ");
        return sc.nextInt();
    }
}
