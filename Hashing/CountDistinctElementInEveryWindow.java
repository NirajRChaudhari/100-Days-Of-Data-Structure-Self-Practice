package Hashing;

import java.util.HashMap;

public class CountDistinctElementInEveryWindow extends HashingParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        System.out.println("\nEnter the size of window : ");
        int window = sc.nextInt();

        System.out.println("\nDistinct elements in every window : ");
        System.out.format("%-10s\t%s", "Window", "Distict No's\n");

        approachOne(array, window);

        System.out.println("\n");
    }

    static void approachOne(int[] array, int window) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < window; i++) {
            hashMap.put(array[i], hashMap.getOrDefault(array[i], 0) + 1);
        }
        System.out.format("%d,%-10d :\t%d\n", 0, window - 1, hashMap.size());

        for (int i = 0; i < array.length - window; i++) {

            hashMap.put(array[i], hashMap.get(array[i]) - 1);

            if (hashMap.get(array[i]) == 0) {
                hashMap.remove(array[i]);
            }

            hashMap.put(array[i + window], hashMap.getOrDefault(array[i + window], 0) + 1);

            System.out.format("%d,%-10d :\t%d\n", i + 1, i + window, hashMap.size());
        }

    }
}
