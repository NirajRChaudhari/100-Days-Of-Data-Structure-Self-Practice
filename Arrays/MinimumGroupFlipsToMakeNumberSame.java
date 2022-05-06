package Arrays;

public class MinimumGroupFlipsToMakeNumberSame extends ArrayParentClass {

    public static void main(String[] args) {

        int[] array = getArray();
        int size = array.length;

        // approachOne(array, size);

        // More efficient approach: https://imgur.com/6hgT4cA
        approachTwo(array, size);
    }

    static void approachOne(int[] array, int size) {

        int zeroGroupCount = 0, oneGroupCount = 0, lastIndex = 0;

        if (array[0] == 0) {
            zeroGroupCount++;
        } else {
            oneGroupCount++;
        }

        for (int i = 1; i < size; i++) {
            if (array[i] != array[i - 1]) {
                if (array[i] == 0) {
                    zeroGroupCount++;
                } else {
                    oneGroupCount++;
                }
            }
        }

        if (zeroGroupCount < oneGroupCount) {
            printGroups(array, 0);
        } else {
            printGroups(array, 1);
        }
    }

    static void printGroups(int[] array, int groupValue) {

        boolean groupStarted = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == groupValue && !groupStarted) {
                groupStarted = true;
                System.out.println("\nFrom : " + i);

            } else if (array[i] != groupValue && groupStarted) {
                System.out.println("To : " + (i - 1));
                groupStarted = false;
            }
        }

        if (array[array.length - 1] == groupValue) {
            System.out.println("To : " + (array.length - 1));

        }
    }

    static void approachTwo(int[] array, int size) {

        for (int i = 1; i < size; i++) {
            if (array[i] != array[i - 1]) {

                // Compare with first element as the first element's group won't be minimum
                // flips group
                if (array[i] != array[0]) {
                    System.out.println("\nFrom : " + i);
                } else {
                    System.out.println("To : " + (i - 1));
                }
            }
        }

        if (array[size - 1] != array[0]) {
            System.out.println("To : " + (size - 1));

        }
    }
}
