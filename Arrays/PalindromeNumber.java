package Arrays;

import java.util.Scanner;

public class PalindromeNumber {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the Number : ");
        int num = sc.nextInt();

        // Approach 1:-
        approach_one(num);

        // Approach 2:-
        // approach_two(num);

        // Approach 3:-
        // Store all the digits in the given Number in an array and
        // then follow the logic of checking palindrome string using 2 pointers

    }

    private static void approach_one(int num) {
        int countOfDigits = findCountOfDigits(num);

        while (num != 0 && num % 10 == (int) (num / Math.pow(10, countOfDigits - 1))) {
            num %= Math.pow(10, countOfDigits - 1);
            num /= 10;
            // System.out.println(num + "\n\n");

            countOfDigits -= 2;
        }

        if (num != 0) {
            System.out.println("Given Number is NOT a Palindrome");
        } else {
            System.out.println("Given Number is a Palindrome");
        }

    }

    private static int findCountOfDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + findCountOfDigits(num / 10);
    }

    private static void approach_two(int num) {

        int num_copy = num;
        int rev_num = 0;

        while (num_copy != 0) {
            int temp = num_copy % 10;
            rev_num = rev_num * 10 + temp;

            num_copy = num_copy / 10;
        }

        if (rev_num == num) {
            System.out.println("Given Number is a Palindrome");
        } else {
            System.out.println("Given Number is NOT a Palindrome");
        }
    }
}
