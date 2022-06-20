package Searching;

public class LinearSearch extends SearchingParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        int key = getNumber();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                System.out.println("\nElement found in the array at index : " + i + "\n");
                return;
            }
        }

        System.out.println("\nElement NOT found in the array\n");
    }
}
