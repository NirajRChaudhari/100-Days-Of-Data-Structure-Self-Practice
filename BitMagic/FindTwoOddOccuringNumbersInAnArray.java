package BitMagic;

//Find two numbers occuring odd number of times in the array
public class FindTwoOddOccuringNumbersInAnArray extends BitMagicParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        approachOne(array);
    }

    static void approachOne(int[] array) {

        int xorOfAllNumbers = 0;

        // Find XOR of all Numbers at end all pairs would cancel and it will have value
        // of XOR of 2 odd occuring numbers
        for (int i = 0; i < array.length; i++) {
            xorOfAllNumbers = xorOfAllNumbers ^ array[i];
        }

        // Find the first set bit from left in xorOfAllNumbers value
        int firstSetBitIndex = 0;
        while ((xorOfAllNumbers & (1 << firstSetBitIndex)) == 1) {
            firstSetBitIndex++;
        }

        int xorSetBitGroup = 0, xorUnsetBitGroup = 0;

        for (int i = 0; i < array.length; i++) {

            if ((array[i] & (1 << firstSetBitIndex)) == 1) {
                xorSetBitGroup = xorSetBitGroup ^ array[i];
            } else {
                xorUnsetBitGroup = xorUnsetBitGroup ^ array[i];
            }
        }

        System.out.println(
                "\nTwo odd occuring numbers in the array are : " + xorSetBitGroup + " and " + xorUnsetBitGroup + "\n");
    }
}
