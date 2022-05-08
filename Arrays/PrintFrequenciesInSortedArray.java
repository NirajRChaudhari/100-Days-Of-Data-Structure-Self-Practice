package Arrays;

public class PrintFrequenciesInSortedArray extends ArrayParentClass {
    public static void main(String[] args) {
        int[] array = getArray();
        int size = array.length;

        int i, cnt = 1;

        System.out.println("\nElement and their frequency are:- ");
        for (i = 0; i < size - 1; i++) {
            if (array[i] == array[i + 1]) {
                cnt++;
            } else {
                System.out.println(array[i] + "   " + cnt);
                cnt = 1;
            }
        }
        System.out.println(array[i] + "   " + cnt);
    }
}
