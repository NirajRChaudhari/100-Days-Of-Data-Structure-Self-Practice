package BitMagic;

public class CheckIfKthBitIsSetInANumber extends BitMagicParentClass {

    public static void main(String[] args) {

        int num = getNumber();

        System.out.println("\nEnter the bit number to be checked if it is set or not : ");
        int checkNum = sc.nextInt();

        int bitNum = 1 << (checkNum - 1);

        System.out.println();

        if ((num & bitNum) == 0) {
            System.out.println("The bit " + checkNum + " is not set in the number " + num);
        } else {
            System.out.println("The bit " + checkNum + " is set in the number " + num);
        }
    }
}
