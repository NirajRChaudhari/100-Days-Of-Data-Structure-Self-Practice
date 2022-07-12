package Strings;

// There is difference in subarray and subsequence
public class CheckIfGivenStringIsSubsequence extends StringParentClass {

    public static void main(String[] args) {

        System.out.println("\nEnter the Main String : ");
        String mainString = sc.nextLine();

        System.out.println("\nEnter the string which is to be checked for subsequence :");
        String checkString = sc.nextLine();

        // Recursive Approach
        if (checkIfSubsequence(mainString, checkString, 0, 0)) {
            System.out.println("\n" + checkString + " is a subsequence of " + mainString
                    + "\n");
        } else {
            System.out.println("\n" + checkString + " is NOT a subsequence of " +
                    mainString + "\n");
        }

        // Iterative Approach
        checkIfSubsequenceIterative(mainString, checkString);
    }

    static boolean checkIfSubsequence(String mainString, String checkString, int mainStringIndex,
            int checkStringIndex) {

        if (checkStringIndex == checkString.length()) {
            return true;
        }

        if (mainStringIndex >= mainString.length() || checkStringIndex >= checkString.length()) {
            return false;
        }

        if (mainString.charAt(mainStringIndex) == checkString.charAt(checkStringIndex)) {
            return checkIfSubsequence(mainString, checkString, mainStringIndex + 1, checkStringIndex + 1);

        } else {
            return checkIfSubsequence(mainString, checkString, mainStringIndex + 1, checkStringIndex);
        }
    }

    static void checkIfSubsequenceIterative(String mainString, String checkString) {

        int mainStringIndex = 0, checkStringIndex = 0;

        while (mainStringIndex < mainString.length()) {

            if (mainString.charAt(mainStringIndex) == checkString.charAt(checkStringIndex)) {
                checkStringIndex++;
            }

            if (checkStringIndex == checkString.length()) {
                System.out.println("\n" + checkString + " is a subsequence of " + mainString + "\n");
                return;
            }

            mainStringIndex++;
        }

        System.out.println("\n" + checkString + " is NOT a subsequence of " + mainString + "\n");

    }
}
