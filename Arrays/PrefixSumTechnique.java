package Arrays;

public class PrefixSumTechnique extends ArrayParentClass {

    public static void main(String[] args) {

        int[] array = getArray();
        int size = array.length;

        // Preprocess and create prefix sum of all elements so that finding sum of
        // elements between any 2 indexes can be done O(N) time instead of O(N)
        int[] prefixSum = new int[size];

        prefixSum[0] = array[0];
        for (int i = 1; i < size; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i];
        }

        System.out.println("\nEnter 2 indexes between whose sum you want to find: ");
        System.out.print("\nEnter Small Index:  ");
        int index1 = sc.nextInt();

        System.out.print("\nEnter Large Index :  ");
        int index2 = sc.nextInt();

        // As current number at index 1 is also getting subtracted so we have to add it
        // again array[index1]
        int sumOfAllElements = prefixSum[index2] - prefixSum[index1] + array[index1];

        System.out
                .println("Sum of all elemets between index " + index1 + " and " + index2 + " is : " + sumOfAllElements);
    }
}
