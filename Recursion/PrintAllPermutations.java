package Recursion;

public class PrintAllPermutations extends RecursionParentClass {
    public static void main(String[] args) {
        System.out.println("\nEnter the String : ");
        String inputString = sc.nextLine();

        System.out.println("\nPermutaions are : ");
        printPermutations(inputString, "");

        System.out.println("");
    }

    static void printPermutations(String inputString, String resultantString) {

        // When single character is remaining in inputString
        if (inputString.length() == 1) {
            System.out.println(resultantString + inputString);
        }

        for (int i = 0; i < inputString.length(); i++) {

            String tempInputString = inputString.substring(0, i) + inputString.substring(i + 1);

            printPermutations(tempInputString, resultantString + inputString.charAt(i));
        }
    }
}
