package Recursion;

public class SumOfDigitsInNumber extends RecursionParentClass {

    public static void main(String[] args) {

        int num = getNumber();

        System.out.println("\nSum of Digits in the Number is : " + sumOfDigits(num) + "\n");
    }

    static int sumOfDigits(int num) {

        if (num == 0) {
            return 0;
        }

        return (num % 10) + sumOfDigits(num / 10);
    }
}
