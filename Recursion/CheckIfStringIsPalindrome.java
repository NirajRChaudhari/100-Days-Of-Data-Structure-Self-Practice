package Recursion;

public class CheckIfStringIsPalindrome extends RecursionParentClass {

    public static void main(String[] args) {

        System.out.println("\nEnter the String to be checked for Palindrome : ");
        String inputString = sc.nextLine();

        if (checkIfPalindrome(inputString, 0, inputString.length() - 1)) {
            System.out.println("Given string is a Palindrome");
        } else {
            System.out.println("Given string is Not a Palindrome");
        }
    }

    static boolean checkIfPalindrome(String inputString, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (inputString.charAt(left) != inputString.charAt(right)) {
            return false;
        }

        return checkIfPalindrome(inputString, left + 1, right - 1);
    }
}
