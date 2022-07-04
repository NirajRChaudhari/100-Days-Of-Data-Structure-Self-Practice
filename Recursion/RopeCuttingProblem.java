package Recursion;

//Problem sample input and output : https://imgur.com/QGu43Ys
public class RopeCuttingProblem extends RecursionParentClass {

    public static void main(String[] args) {

        System.out.println("\nEnter the length of the rope : ");
        int length = sc.nextInt();

        System.out.println("\nEnter length of piece A");
        int a = sc.nextInt();
        System.out.println("Enter length of piece B");
        int b = sc.nextInt();
        System.out.println("Enter length of piece C");
        int c = sc.nextInt();

        System.out.println(
                "\nMaximum cuts possible in the rope are : " + getMaximumCutsPossible(length, a, b, c, 0) + "\n");

    }

    static int getMaximumCutsPossible(int length, int a, int b, int c, int cutsCount) {

        if (length == 0) {
            return cutsCount;
        }

        if (length < 0) {
            return -1;
        }

        int countUsingA = getMaximumCutsPossible(length - a, a, b, c, cutsCount + 1);
        int countUsingB = getMaximumCutsPossible(length - b, a, b, c, cutsCount + 1);
        int countUsingC = getMaximumCutsPossible(length - c, a, b, c, cutsCount + 1);

        // Find maximum count from all 3 scenarios if all scenario have return -1 so
        // max=-1 hence return -1
        int maxCount = Math.max(countUsingA, countUsingB);
        maxCount = Math.max(maxCount, countUsingC);

        if (maxCount == -1) {
            return -1;
        }

        return maxCount;
    }
}
