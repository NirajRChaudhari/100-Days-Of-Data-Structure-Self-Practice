package Recursion;

public class GetSumOfNNaturalNumbers extends RecursionParentClass {

    public static void main(String[] args) {

        int num = getNumber();

        System.out.println("\nSum of all natural numbers below" + num + " is : " + sumOfNNaturalNumbers(num) + "\n");
    }

    static int sumOfNNaturalNumbers(int num) {

        if (num == 0) {
            return 0;
        }

        return num + sumOfNNaturalNumbers(num - 1);
    }
}
