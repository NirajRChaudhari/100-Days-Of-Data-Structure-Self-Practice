package Searching;

public class FindSquareRoot extends SearchingParentClass {

    public static void main(String[] args) {

        System.out.println("\nEnter the number whose whole number square root has to be found : ");
        int num = sc.nextInt();

        // Efficient way to find square root O(logN)
        int squareRoot = findSquareRoot(num, 0, num);

        if (squareRoot == -1) {
            System.out.println("\nGiven number does NOT have whole number square root \n");
        } else {
            System.out.println("\nSquare root of the given number is " + squareRoot + "\n");
        }
    }

    static int findSquareRoot(int num, int left, int right) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (mid * mid == num) {
            return mid;

        } else if (num < (mid * mid)) {
            return findSquareRoot(num, left, mid - 1);
        } else {
            return findSquareRoot(num, mid + 1, right);
        }
    }
}
