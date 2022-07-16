package Strings;

import java.util.HashMap;

public class CheckIfAnagram extends StringParentClass {

    public static void main(String[] args) {

        System.out.println("\nEnter First String : ");
        String s1 = sc.nextLine();

        System.out.println("\nEnter Second String : ");
        String s2 = sc.nextLine();

        if (isAnagram(s1, s2)) {
            System.out.println("\nGiven strings are Anagram\n");

        } else {
            System.out.println("\nGiven strings are NOT a Anagram\n");
        }
    }

    static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {

            char s1char = s1.charAt(i);
            char s2char = s2.charAt(i);

            hashMap.put(s1char, hashMap.getOrDefault(s1char, 0) + 1);

            hashMap.put(s2char, hashMap.getOrDefault(s2char, 0) - 1);

            if (hashMap.get(s1char) != null && hashMap.get(s1char) == 0) {
                hashMap.remove(s1char);
            }

            if (hashMap.get(s2char) != null && hashMap.get(s2char) == 0) {
                hashMap.remove(s2char);
            }
        }

        return hashMap.size() == 0 ? true : false;
    }
}
