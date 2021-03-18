package ro.fasttrackit.curs6;

import java.util.Arrays;

public class Redact {
    public static void main(String[] args) {
        int count = countChar("testare test mult", 't');
        System.out.println(count);
        System.out.println(countCharWhile("testare test mult", 't'));
        String redacted = redact("words");
        System.out.println(redacted);
        System.out.println(redactSimple("words"));
        System.out.println(contains(new String[]{"Ana", "are", "mere", "multe", "marunte"}, "pere"));
        System.out.println(Arrays.toString(phraseToArray("Ana are mere multe")));

        System.out.println(sri("Ana are mere multe si marunte", new String[]{"mere", "marunte", "Ana"}));
    }

    private static String sri(String phrase, String[] censorWords) {
        String[] phraseWords = phraseToArray(phrase);
        String censored = "";
        for (String word : phraseWords) {
            if (contains(censorWords, word)) {
                censored = censored + redact(word) + " ";
            } else {
                censored = censored + word + " ";
            }
        }
        return censored;
    }

    private static String[] phraseToArray(String phrase) {
        return phrase.split(" ");
    }

    private static boolean contains(String[] words, String search) {
        for (String word : words) {
            if (word.equalsIgnoreCase(search)) {
                return true;
            }
        }
        return false;
    }

    public static String redactSimple(String word) {
        return word.replaceAll(".", "*");
    }

    public static String redact(String word) {
        int length = word.length();
        String result = "";
        int i = 0;
        while (i != length) {
            result = result + '*';
            i++;
        }
        return result;
    }

    public static int countChar(String word, char letterToSearch) {
        int count = 0;
        for (char wordLetter : word.toCharArray()) {
            if (wordLetter == letterToSearch) {
                count++;
            }
        }
        return count;
    }

    public static int countCharWhile(String word, char letterToSearch) {
        int count = 0;
        while (!word.isEmpty()) {
            if (word.charAt(word.length() - 1) == letterToSearch) {
                count++;
            }
            word = word.substring(0, word.length() - 1);
        }
        return count;
    }


}
