package ch5;

import java.util.Arrays;
import java.util.Vector;

public class Statics {
    public static void main(String[] args) {
//        System.out.println(delimitedString(args[0], args[1].charAt(0), args[2].toCharArray()[0]));
//        System.out.println(encode("äzXyä"));

        // Test encode
        String delimiter = "|";
        String original = "Hi! We'll be <br> using| pipes| as <br> our| delimiter.";
        String[] expected = {"Hi! We'll be <br> using", " pipes", " as <br> our", " delimiter."};
        String[] result = extract(original, delimiter);

        System.out.format("Original string: %s%n", original);
        System.out.format("Expected string: %s%n", Arrays.toString(expected));
        System.out.format("Result string: %s%n", Arrays.toString(result));

        System.out.println("\n\n--------------\n\n");

        // Test encode long
        String delimiterLong = "<br>";
        String originalLong = "Hi! We'll be<br><br> <br> using| breaks| as <br> our| delimiter.<br><br>";
        String[] expectedLong = {"Hi! We'll be", " ", " using| breaks| as ", " our| delimiter."};
        String[] resultLong = extract(originalLong, delimiterLong);

        System.out.format("Original string: %s%n", originalLong);
        System.out.format("Expected string: %s%n", Arrays.toString(expectedLong));
        System.out.format("Result string: %s%n", Arrays.toString(resultLong));
    }

    /**
     *  Take a {@code String} and return the first, shortest, substring of it starting with {@code start} and ends
     *  with {@code end}.
     *
     * @param s Input string
     * @param start Starting character
     * @param end Ending character
     * @return substring of s
     */
    public static String delimitedString(String s, char start, char end) {
        // Iterate over string until start is found
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != start) continue;

            String result = "";
            // Once character matches start, iterate over string
            for (int j = i; j < s.length(); j++) {
                char curr = s.charAt(j);
                result += curr;

                // Exit once end is found
                if (curr == end) return result;
            }
        }

        // Return null if substring not found
        return null;
    }

    /**
     * Takes {@code text} into lowercase and replaces each letter with its
     * numerical position in the alphabet.
     *
     * Umlauts are converted to their English counterparts.
     *
     * @param text
     * @return {@code String} encoded text
     */
    public static String encode(String text) {
        // Take text into lowercase
        text = text.toLowerCase();

        // Replace all umlauts
        text = text.replace("ä", "ae");
        text = text.replace("ß", "ss");
        text = text.replace("ü", "ue");
        text = text.replace("ö", "oe");

        // Iterate over each letter replacing it with equivalent numerical
        // position in the alphabet
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            result += text.charAt(i) - 'a' + 1;
        }

        return result;
    }

    public static String[] extract(String text, String delim) {
        Vector<String> buffer = new Vector<String>();
        String word = "";

        // Using two pointers to navigate words and delimiters, iterate over entire string
        for (int i = 0; i < text.length(); i++) {
            char curr = text.charAt(i);
            if (curr != delim.charAt(0)) {
                word += curr;
                continue;
            }

            // Check when delimiter is found
            boolean found = true;
            String temp = String.valueOf(curr);
            for (int j = 1; j < delim.length(); j++, i++) {
                if (text.charAt(i + 1) != delim.charAt(j)) {
                    found = false;
                    break;
                }

                temp += delim.charAt(j);
            }

            if (found) {
                if(word.length() > 0) buffer.add(word);
                word = "";
            } else {
                word += temp;
            }
        }

        if (word.length() > 0) {
            buffer.add(word);
        }

        String[] a = {};
        return buffer.toArray(a);
    }
}