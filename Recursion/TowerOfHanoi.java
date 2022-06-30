package Recursion;

public class TowerOfHanoi extends RecursionParentClass {

    public static void main(String[] args) {

        System.out.println("\nEnter total no. of discs : ");
        int discs = sc.nextInt();

        System.out.println("\nSteps to Move all discs from A to C are : \n");
        solveTowerOfHanoi(discs, "A", "B", "C");
        System.out.println("\n");
    }

    static void solveTowerOfHanoi(int disc, String A, String B, String C) {

        if (disc == 1) {
            System.out.println("Move disc " + disc + " from " + A + " to " + C);
            return;
        }

        solveTowerOfHanoi(disc - 1, A, C, B);

        System.out.println("Move disc " + disc + " from " + A + " to " + C);

        solveTowerOfHanoi(disc - 1, B, A, C);
    }
}
