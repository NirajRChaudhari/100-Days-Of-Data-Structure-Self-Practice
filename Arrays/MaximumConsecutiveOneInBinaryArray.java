package Arrays;

public class MaximumConsecutiveOneInBinaryArray extends ArrayParentClass {
    public static void main(String[] args) {

        int[] array = getArray();
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
}
