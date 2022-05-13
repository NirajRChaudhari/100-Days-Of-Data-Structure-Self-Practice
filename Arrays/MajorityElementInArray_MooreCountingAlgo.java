package Arrays;

public class MajorityElementInArray_MooreCountingAlgo extends ArrayParentClass {

    // Majority element is the element which appears more than N/2 times in an array
    // where N is the size of array

    public static void main(String[] args) {

        int[] array = getArray();
        int size = array.length;

        // O(N^2)
        // approachOne(array, size);

        // Moore's algorithm O(N)
        approachTwo(array, size);
    }

    static void approachOne(int[] array, int size) {

        int count, maxCount = 0, maxElement = 0;

        for (int i = 0; i < size; i++) {

            count = 0;

            for (int j = i; j < size; j++) {
                if (array[j] == array[i]) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                maxElement = array[i];
            }
        }

        if (maxCount > size / 2) {
            System.out.println(
                    "The Majority element in the array is : " + maxElement + " and it's count is : " + maxCount);
        } else {
            System.out.println("There are no Majority element in the array");
        }
    }

    static void approachTwo(int[] array, int size) {

        // Find Maximum count or repeated number
        int count = 1, maxCountNumberIndex = 0;
        for (int i = 1; i < size; i++) {
            if (array[i] == array[maxCountNumberIndex]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                maxCountNumberIndex = i;
                count = 1;
            }
        }

        // Validate if the maximum repeated number is Majority Element
        count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == array[maxCountNumberIndex]) {
                count++;
            }
        }

        if (count > size / 2) {
            System.out.println(
                    "The Majority element in the array is : " + array[maxCountNumberIndex]);
        } else {
            System.out.println("There are no Majority element in the array");
        }
    }
}
