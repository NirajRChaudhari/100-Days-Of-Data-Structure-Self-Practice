package Recursion;

public class TailRecursionFactorial extends RecursionParentClass {

    public static void main(String[] args) {

        int num = getNumber();

        // Approach 1 : Normal Recursion
        int fact1 = findFactNormalRecursion(num);
        System.out.println("Factorial : " + fact1);

        // Approach 2 : Tail Recursion (More efficient)
        // Converts recursive call into labels and goto statement to reduce stack
        // overhead
        // Quick sort(use tail recursion) faster than Merge sort
        // Inorder, Preorder faster than postorder
        int fact2 = 1;
        fact2 = findFactTailRecursion(num, fact2);
        System.out.println("Factorial : " + fact2);

    }

    static int findFactNormalRecursion(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }

        int fact = findFactNormalRecursion(num - 1);
        // This function is not a tail recursion as some operation is performed after
        // recursive call
        return num * fact;
    }

    static int findFactTailRecursion(int num, int factorial) {
        // For Tail recursion compiler will add here label start:
        if (num == 0 || num == 1) {
            return factorial;
        }

        // Compiler will replace below line by num=num-1, factorial = factorial*num and
        // add goto start
        return findFactTailRecursion(num - 1, factorial * num);
    }
}
