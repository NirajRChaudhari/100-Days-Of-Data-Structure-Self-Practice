package Arrays;

// Leader is an element to whose right all elements are smaller than it
public class FindLeadersInArray extends ArrayParentClass {
    public static void main(String[] args) {

        int[] array = getArray();
        int size = array.length;

        System.out.println("The Leader element in the array are: ");

        System.out.println(array[size - 1]);
        int largestTillNow = array[size - 1];

        for (int i = size - 2; i >= 0; i--) {
            if (array[i] > largestTillNow) {
                largestTillNow = array[i];
                System.out.println(array[i]);
            }
        }
    }
}
