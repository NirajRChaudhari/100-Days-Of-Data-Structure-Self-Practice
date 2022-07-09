package Recursion;

public class GenerateSubsetsOfString extends RecursionParentClass {

    public static void main(String[] args) {

        System.out.println("\nEnter the String : ");
        String inputString = sc.nextLine();

        System.out.println("\nAll Subsets of the String are :");
        generateSubsets(inputString, "", 0);
    }

    static void generateSubsets(String inputString, String targetString, int currentIndex) {

        if (currentIndex == inputString.length()) {
            System.out.println(targetString);
            return;
        }

        generateSubsets(inputString, targetString, currentIndex + 1);
        generateSubsets(inputString, targetString + inputString.charAt(currentIndex), currentIndex + 1);
    }
}
