package Strings;

import java.util.Arrays;

public class LeftmostRepeatingCharacter extends StringParentClass {

    // Problem : https://imgur.com/0lJF2C2
    public static void main(String[] args) {

        System.out.println("\nEnter the String : ");
        String str = sc.nextLine();

        // O(N) needs to traverse string twice
        // approachOne(str);

        // O(N) needs to traverse string once
        approachTwo(str);
    }

    static void approachOne(String str) {
        // Considering string may contain all ASCII values size=256
        int[] count = new int[256];

        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;

            if (count[str.charAt(i)] > 1 && i < smallest) {
                smallest = i;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] >= 2) {
                System.out.println("\nLeftmost Repeating Character is : " + str.charAt(i) + "\n");
                return;
            }
        }

        System.out.println("\nGiven String has NO repeating characters\n");
    }

    static void approachTwo(String str) {
        // Considering string may contain all ASCII values size=256
        int[] smallestOccurringPosition = new int[256];
        Arrays.fill(smallestOccurringPosition, -1);

        int overallSmallestPos = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {

            int characterSmallestPos = smallestOccurringPosition[str.charAt(i)];

            if (characterSmallestPos != -1 && characterSmallestPos < overallSmallestPos) {
                overallSmallestPos = characterSmallestPos;
                // No need to update smallestOccurringPosition[str.charAt(i)] as earlier value
                // will always be smaller than current i

            } else {
                smallestOccurringPosition[str.charAt(i)] = i;
            }
        }

        if (overallSmallestPos == Integer.MAX_VALUE) {
            System.out.println("\nGiven String has NO repeating characters\n");

        } else {
            System.out.println("\nLeftmost Repeating Character is : " + str.charAt(overallSmallestPos) + "\n");
        }
    }
}
