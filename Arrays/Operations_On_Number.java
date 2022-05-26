package Arrays;

import java.util.Scanner;

class Operations_On_Number {

    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {

        System.out.println("\nEnter the Number :- ");
        int num = sc.nextInt();

        // ***** UNCOMMENT THE TASK CODE WHICH YOU WANT TO RUN *****

        // Task 1:- Count Number of Digits in number
        // System.out.println("Total Number of digits : " +
        // countNumberOfDigitsInNumber(num));

        // Task 2:- Find the Factorial of a given number
        // System.out.println("Factorial of given number is : " + findFactorial(num));

        // Task 3:- Find total count of trailing zeroes in the factorial of given number
        // Important example as it avoids finding factorial of number as it can cause
        // overflow in some cases
        System.out.println(
                "Total trailing zeroes in the factorial of given number are : " +
                        countTrailingZeroesInFactorial(num));

        // Task 4:- Find GCD and LCM of 2 numbers
        // System.out.println("\nEnter the second Number :- ");
        // int num2 = sc.nextInt();
        // System.out.println("GCD of this 2 given numbers is : " + findGCD(num, num2));
        // System.out.println("LCM of this 2 given number is : " + findLCM(num, num2));

        // Task 5:- Check if the number is prime or not
        // checkIfNumberIsPrime(num);

        // Task 6:- Print all Divisors of given number in ascending order
        // printAllDivisorsOfNumberInAscendingOrder(num);

        // Task 7:- Print all prime numbers less than the given number
        // printAllPrimesLessThanGivenNumber(num);

    }

    private static int countNumberOfDigitsInNumber(int num) {
        if (num / 10 == 0) {
            return 1;
        }

        return 1 + countNumberOfDigitsInNumber(num / 10);
    }

    private static int findFactorial(int num) {

        if (num == 1 || num == 0) {
            return 1;
        }
        return num * findFactorial(num - 1);
    }

    private static int countTrailingZeroesInFactorial(int num) {

        int zeroesCount = 0;

        // Calculate Total number of 5 factors in all numbers <= num as 5 and 2 pair
        // lead to 0 (5*2) so total number of 5 or 2(whichever is less in count) that
        // many pairs will be formed so we search for total 5's to know total pairs
        for (int i = 5; i <= num; i = i * 5) {
            zeroesCount = zeroesCount + num / i;
        }

        return zeroesCount;
    }

    private static int findGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }

        return findGCD(num2 % num1, num1);
    }

    private static int findLCM(int num1, int num2) {
        int gcd = findGCD(num1, num2);

        return (num1 * num2) / gcd;
    }

    private static void checkIfNumberIsPrime(int num) {

        // Divide and check from i=2 to sqrt(num)
        for (int i = 2; i * i <= num; i++) {

            if (num % i == 0) {
                System.out.println("The given number is NOT Prime.");
                return;
            }
        }
        System.out.println("The given number is Prime.");
    }

    private static void printAllDivisorsOfNumberInAscendingOrder(int num) {

        int i;
        // Divisors will be pair of 2 numbers whose multiplication will lead to num. In
        // each pair one number will always be less than sqrt(num) and other would be
        // greater than sqrt(num), so we need to for loops as we have to print all
        // divisors in ascending order

        System.out.println("\nDivisors of the given Number are :- ");
        for (i = 1; i * i < num; i++) {
            if (num % i == 0) {
                System.out.println(i);
            }
        }

        for (; i >= 1; i--) {
            if (num % i == 0) {
                System.out.println(num / i);
            }
        }
        System.out.println("\n");
    }

    private static void printAllPrimesLessThanGivenNumber(int num) {

        boolean[] numbers = new boolean[num + 1];

        for (int i = 2; i * i <= num; i++) {
            for (int j = i * i; j <= num; j = j + i) {
                // Mark all multiples of j as non prime
                numbers[j] = true;
            }
        }

        System.out.println("\nAll the prime numbers less than " + num + " are:- ");

        // i starts from 2 as 0,1 are not prime
        for (int i = 2; i < num; i++) {
            if (!numbers[i]) {
                System.out.println(i);
            }
        }
    }

}
