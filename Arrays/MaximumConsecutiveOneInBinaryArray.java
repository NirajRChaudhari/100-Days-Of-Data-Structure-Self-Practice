package Arrays;

public class MaximumConsecutiveOneInBinaryArray extends ArrayParentClass {
    public static void main(String[] args) {

        int[] array = getArray();

        // approachOne(array);
        approachTwo(array);
    }

    static void approachOne(int[] array) {

        int size = array.length;

        int maxcount = 0, cnt = 0;
        for (int i = 0; i < size; i++) {
            cnt = 0;
            while (i < size && array[i] == 1) {
                cnt++;
                i++;
            }

            if (cnt > maxcount) {
                maxcount = cnt;
            }
        }

        System.out.println("\nMaximum Consecutive 1's in Binary Array are :  " + maxcount);
    }

    static void approachTwo(int[] array) {

        int cnt = 0, maxcount = 0;

        if (array[0] == 1) {
            cnt++;
            maxcount = cnt;
        }

        for (int i = 1; i < array.length; i++) {

            if (array[i] != array[i - 1] && array[i] == 0) {

                if (maxcount < cnt) {
                    maxcount = cnt;
                }
                cnt = 0;
            }

            if (array[i] == 1) {
                cnt++;
            }
        } // for

        if (maxcount < cnt) {
            maxcount = cnt;
        }

        System.out.println("\nMaximum Consecutive 1's in Binary Array are :  " + maxcount);
    }
}
