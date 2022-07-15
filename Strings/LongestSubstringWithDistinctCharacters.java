package Strings;

import java.util.Arrays;

// Problem : https://imgur.com/M6MQb40
public class LongestSubstringWithDistinctCharacters extends StringParentClass {

    public static void main(String[] args) {
        System.out.println("\nEnter the String");
        String string = sc.nextLine();

        // approachOne(string);

        efficientApproachOne(string);
    }

    static void efficientApproachOne(String string) {

        int prevOccurence[] = new int[266];

        Arrays.fill(prevOccurence, -1);

        int maxLen = 0, lastIndex = 0;
        for (int i = 0; i < string.length(); i++) {

            lastIndex = Math.max(lastIndex, prevOccurence[string.charAt(i)] + 1);

            maxLen = Math.max(maxLen, i - lastIndex + 1);

            prevOccurence[string.charAt(i)] = i;
        }

        System.out.println("\nLongest substring with distinct characters " + maxLen + "\n");
    }

    // static void approachOne(String string) {
    // HashMap<Character, Integer> hashMap = new HashMap<>();

    // int maxCnt = 0, start = 0;
    // for (int i = 0; i < string.length(); i++) {
    // Integer currentNumPrevPos = hashMap.get(string.charAt(i));

    // if (currentNumPrevPos != null) {

    // if (i - currentNumPrevPos > maxCnt) {
    // maxCnt = i - currentNumPrevPos;
    // }
    // for (int j = start; j <= currentNumPrevPos; j++) {
    // hashMap.remove(string.charAt(j));
    // }

    // start = currentNumPrevPos + 1;
    // }

    // hashMap.put(string.charAt(i), i);
    // }
    // if (string.length() - start > maxCnt) {
    // maxCnt = string.length() - start;
    // }
    // System.out.println("\nLongest substring with distinct characters " + maxCnt +
    // "\n");
    // }

}
