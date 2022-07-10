package Strings;

public class RabinCarpPatternSearchingTechnique extends StringParentClass {

    public static void main(String[] args) {

        System.out.println("\nEnter the Main string :");
        String mainString = sc.nextLine();

        System.out.println("\nEnter the pattern :");
        String pattern = sc.nextLine();

        rabinCarpPatternSearch(mainString, pattern);
    }

    static int hashFunction(int sum) {
        return sum % 1111;
    }

    static void rabinCarpPatternSearch(String mainString, String pattern) {

        int patternSum = 0;
        for (int i = 0; i < pattern.length(); i++) {
            patternSum += pattern.charAt(i);
        }
        int patternHash = hashFunction(patternSum);

        int charSum = 0;
        for (int i = 0; i < pattern.length(); i++) {
            charSum += mainString.charAt(i);
        }

        boolean patternNotPresent = true;

        for (int i = 0; i <= mainString.length() - pattern.length(); i++) {

            if (i != 0) {
                charSum = charSum - mainString.charAt(i - 1);
                charSum = charSum + mainString.charAt(i + pattern.length() - 1);
            }

            if (patternHash == hashFunction(charSum)) {

                int j = 0;
                for (; j < pattern.length(); j++) {
                    if (pattern.charAt(j) != mainString.charAt(i + j)) {
                        break;
                    }
                }

                if (j == pattern.length()) {
                    // Use the flag to print this text in first iteration
                    if (patternNotPresent) {
                        System.out.println("\nGiven pattern is present at index : ");
                        patternNotPresent = false;
                    }

                    System.out.println(i);
                }
            }

        }

        if (patternNotPresent) {
            System.out.println("\nGiven Pattern is NOT present in the String");
        }
        System.out.println("\n");
    }
}
