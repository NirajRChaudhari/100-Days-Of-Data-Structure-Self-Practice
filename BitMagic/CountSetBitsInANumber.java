package BitMagic;

public class CountSetBitsInANumber extends BitMagicParentClass {

    public static void main(String[] args) {

        int num = getNumber();

        // Time Complexity O(N) where N is total number of bits in the number
        // approachOne(num);

        // More efficient O(S) where S is only the number of set bits in the number
        approachTwo(num);

    }

    static void approachOne(int num) {
        int count = 0, tempNum = num;

        do {
            if ((tempNum & 1) == 1) {
                count++;
            }

            tempNum = tempNum >> 1;
        } while (tempNum > 0);

        System.out.println("\nTotal number of set bits in the number " + num + " are : " + count + "\n");
    }

    static void approachTwo(int num) {

        int count = 0, tempNum = num;

        do {
            count++;
            tempNum = tempNum & (tempNum - 1);
        } while (tempNum > 0); // tempNum!=0

        System.out.println("\nTotal number of set bits in the number " + num + " are : " + count + "\n");
    }
}
