package Arrays;

public class TrappingRainWater extends ArrayParentClass {
    public static void main(String[] args) {

        int[] array = getArray();
        int size = array.length;

        // O(n^2)
        approachOne(array, size);

        // O(n^1)
        approachTwo(array, size);
    }

    static void approachOne(int[] array, int size) {
        int waterCollected = 0, leftLargest, rightLargest;

        for (int i = 0; i < size; i++) {

            leftLargest = rightLargest = array[i];

            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > leftLargest) {
                    leftLargest = array[j];
                }
            }

            for (int j = i + 1; j < size; j++) {
                if (array[j] > rightLargest) {
                    rightLargest = array[j];
                }
            }

            waterCollected = waterCollected + (Math.min(leftLargest, rightLargest)) - array[i];
        }

        System.out.println("Maximum water collected is : " + waterCollected);
    }

    static void approachTwo(int[] array, int size) {

        int leftMax[] = new int[size], rightMax[] = new int[size];

        int maxLeftElement = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (maxLeftElement < array[i]) {
                maxLeftElement = array[i];
            }
            leftMax[i] = maxLeftElement;
        }

        int maxRightElement = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (maxRightElement < array[i]) {
                maxRightElement = array[i];
            }
            rightMax[i] = maxRightElement;
        }

        int totalWaterCollected = 0;
        for (int i = 0; i < size; i++) {
            totalWaterCollected = totalWaterCollected + (Math.min(leftMax[i], rightMax[i]) - array[i]);
        }
    }
}
