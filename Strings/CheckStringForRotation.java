package Strings;

// Problem : https://imgur.com/7cyiGBV
public class CheckStringForRotation extends StringParentClass {
    public static void main(String[] args) {

        System.out.println("\nEnter the Main String : ");
        String mainString = sc.nextLine();

        System.out.println("\nEnter the string which is to be checked for rotation :");
        String checkString = sc.nextLine();

        if (approachOne(mainString, checkString)) {
            System.out.println("\n" + checkString + " CAN be obtained by rotating " + mainString + "\n");

        } else {
            System.out.println("\n" + checkString + " CANNOT be obtained by rotating " + mainString + "\n");
        }
    }

    static boolean approachOne(String mainString, String checkString) {

        if (mainString.length() != checkString.length()) {
            return false;
        }

        int i = 0, j = 0;

        do {

            if (mainString.charAt(i) == checkString.charAt(j)) {
                j++;
                i = (i + 1) % mainString.length();

                if (j == checkString.length()) {
                    return true;
                }

            } else {
                j = 0;
                i = (i - j + 1) % mainString.length();
            }

        } while ((i != 0 || j != 0));

        return false;
    }

}
