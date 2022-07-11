package Strings;

//When pattern has all distinct characters but main string can have repeated characters
public class NaivePatternSearchWhenPatternHasAllUniqueCharacters extends StringParentClass {

    public static void main(String[] args) {

        System.out.println("\nEnter the Main string :");
        String mainString = sc.nextLine();

        System.out.println("\nEnter the pattern :");
        String pattern = sc.nextLine();

        naiveSearchWithPatternHavingDistinctCharacters(mainString, pattern);
    }

    static void naiveSearchWithPatternHavingDistinctCharacters(String mainString, String pattern) {

        boolean patternNotPresent = true;

        for (int i = 0; i <= mainString.length() - pattern.length(); i++) {

            int j = 0;
            for (; j < pattern.length(); j++) {
                if (mainString.charAt(i + j) != pattern.charAt(j)) {
                    i = i + j;
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

        if (patternNotPresent) {
            System.out.println("\nGiven Pattern is NOT present in the String");
        }
        System.out.println("\n");
    }
}
