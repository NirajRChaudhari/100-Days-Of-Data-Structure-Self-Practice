package BitMagic;

//Find one number occuring odd number of times in the array
public class FindOnlyOddOccuringNumber extends BitMagicParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        approachOne(array);
    }

    static void approachOne(int[] array) {

        int uniqueElement = 0;

        for (int i = 0; i < array.length; i++) {
            uniqueElement = uniqueElement ^ array[i];
        }

        if (uniqueElement != 0) {
            System.out.println("\nUnique element in the array is : " + uniqueElement + "\n");
        }
    }
}
