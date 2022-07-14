package Strings;

public class ReverseWordsInAString extends StringParentClass {

    public static void main(String[] args) {

        System.out.println("\nEnter the String :");
        String sentence = sc.nextLine();

        reverseWords(sentence);

        efficientReverseWords(sentence);
    }

    static void reverseWords(String sentence) {

        String reverseSentence = "";
        int wordEndIndex = sentence.length();

        for (int i = sentence.length() - 1; i >= 0; i--) {

            if (sentence.charAt(i) == ' ') {
                reverseSentence = reverseSentence + " " + sentence.substring(i + 1, wordEndIndex);

                wordEndIndex = i;
            }
        }

        reverseSentence = reverseSentence + " " + sentence.substring(0, wordEndIndex);

        System.out.println("\nString with reverse words is : " + reverseSentence + "\n");
    }

    static void efficientReverseWords(String sentenceString) {

        char[] sentence = sentenceString.toCharArray();

        int start = 0;
        for (int i = 0; i < sentence.length; i++) {

            if (sentence[i] == ' ') {
                reverseWord(sentence, start, i - 1);
                start = i + 1;
            }
        }

        reverseWord(sentence, start, sentence.length - 1);

        reverseWord(sentence, 0, sentence.length - 1);

        System.out.println("\nString with reverse words is : " + new String(sentence) + "\n");
    }

    static void reverseWord(char[] sentence, int start, int end) {

        while (start < end) {
            char temp = sentence[start];
            sentence[start] = sentence[end];
            sentence[end] = temp;

            start++;
            end--;
        }

    }
}
