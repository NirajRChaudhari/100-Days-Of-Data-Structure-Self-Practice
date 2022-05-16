package Arrays;

public class EquilibriumIndexOfArray extends ArrayParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        System.out.println("\n\nProcessing ...\n");

        int arraySum = 0;
        for (int i = 0; i < array.length; i++) {
            arraySum += array[i];
        }

        int leftSum = 0;
        for (int i = 0; i < array.length; i++) {

            if (leftSum == (arraySum - leftSum - array[i])) {
                System.out.println("Equilibrium Element of the Array is " + array[i] + " at index " + (i + 1));
                return;
            }
            leftSum += array[i];
        }
        System.out.println("Given array has no Equilibrium element..");
    }
}
