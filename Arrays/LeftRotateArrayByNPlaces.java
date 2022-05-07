package Arrays;

public class LeftRotateArrayByNPlaces extends ArrayParentClass {
    public static void main(String[] args) {

        int array[] = getArray();

        System.out.println("\nLeft rotation has to be done by how many places? ");
        int rotationCount = sc.nextInt();

        // approachOne(array, rotationCount);

        // More Efficient :- Reversal Algorithm
        approachTwo(array, rotationCount);
    }

    static void approachOne(int[] array, int rotationCount) {
        int tempArray[] = new int[rotationCount];
        int tempIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (i < rotationCount) {
                tempArray[i] = array[i];
            } else {
                array[tempIndex] = array[i];
                tempIndex++;
            }
        }

        tempIndex = array.length - rotationCount;
        for (int i = 0; i < rotationCount; i++) {
            array[tempIndex] = tempArray[i];
            tempIndex++;
        }

        printArray(array, array.length);
    }

    static void approachTwo(int[] array, int rotationCount) {

        reverse(array, 0, rotationCount - 1);
        reverse(array, rotationCount, array.length - 1);
        reverse(array, 0, array.length - 1);

        printArray(array, array.length);
    }

    static void reverse(int[] array, int left, int right) {
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }
}
