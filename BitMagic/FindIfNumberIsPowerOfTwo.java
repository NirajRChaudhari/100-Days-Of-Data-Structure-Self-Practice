package BitMagic;

public class FindIfNumberIsPowerOfTwo extends BitMagicParentClass {

    public static void main(String[] args) {

        int number = getNumber();

        // Important bitwise condition for number which is power of 2
        if ((number & (number - 1)) == 0) {
            System.out.println("\nGiven Number is power of Two\n");
        } else {
            System.out.println("\nGiven Number is not the power of Two\n");
        }
    }
}
