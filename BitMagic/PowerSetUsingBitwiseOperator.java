package BitMagic;

import java.util.ArrayList;

public class PowerSetUsingBitwiseOperator extends BitMagicParentClass {

    public static void main(String[] args) {

        System.out.println("\nEnter the String whose Power Set has to be displayed : ");
        String inputString = sc.nextLine();

        // Naive iterative approach O(N^2)
        // approachOne(inputString);

        // Bitwise operator based approach )(N^2)
        approachTwo(inputString);
    }

    static void approachOne(String inputString) {

        int size = inputString.length();

        ArrayList<String> powerSet = new ArrayList<>();

        System.out.println("\nPower Set : ");
        powerSet.add("");
        for (int i = 0; i < size; i++) {

            for (int j = i; j < size; j++) {
                powerSet.add(inputString.substring(i, j + 1));
            }
        }

        for (String string : powerSet) {
            System.out.println(string);
        }
    }

    static void approachTwo(String inputString) {

        int size = inputString.length();
        ArrayList<String> powerSet = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, size); i++) {
            String combinationString = "";

            for (int j = 0; j < size; j++) {
                if ((i & (1 << j)) != 0) {
                    combinationString += inputString.charAt(j);
                }
            }
            powerSet.add(combinationString);
        }

        System.out.println("\nPower Set : ");
        for (String string : powerSet) {
            System.out.println(string);
        }
    }
}
