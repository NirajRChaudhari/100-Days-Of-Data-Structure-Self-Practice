package Arrays;

public class MaximumLengthOfEvenOddSubarray extends ArrayParentClass {
    public static void main(String[] args) {

        int[] array = getArray();
        int size = array.length;

        System.out.println("Maximum Length of Even Odd SubArray is : " +
                approachOne(array, size));

        System.out.println("Maximum Length of Even Odd SubArray is : " + approachTwo(array, size));

    }

    static int approachOne(int[] array, int size) {
        if (size == 1) {
            return 1;
        }

        int cnt = 1, maxCnt = 1;
        for (int i = 0; i < size - 1; i++) {

            // To check if consecutive numbers are even-odd or odd-even check if there sum
            // is odd
            if ((array[i] + array[i + 1]) % 2 == 1) {
                cnt++;
            } else {
                cnt = 1;
            }

            if (maxCnt < cnt) {
                maxCnt = cnt;
            }
        }

        if (maxCnt < cnt) {
            maxCnt = cnt;
        }

        return maxCnt;
    }

    static int approachTwo(int[] array, int size) {

        int cnt = 1, maxCnt = 1;

        for (int i = 1; i < size; i++) {

            if ((array[i - 1] + array[i]) % 2 == 0) {
                if (maxCnt < cnt) {
                    maxCnt = cnt;
                }
                cnt = 0;
            }

            cnt++;
        } // for

        if (maxCnt < cnt) {
            maxCnt = cnt;
        }

        return maxCnt;
    }
}
