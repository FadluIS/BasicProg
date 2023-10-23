package ch5;

import java.util.Hashtable;
import java.util.Vector;
/*
USE THIS FORMAT
java ch6.Statics dowabdsjal o a => owa // Result is wrong! Should be: owabdsja
java ch6.Statics dowabddowabdsjal o a => owa
 */

public class Statics {
    public static void main(String[] args) {

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
        boolean found = false;
        String result = "";

        // Iterate over string until start is found
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != start) continue;

            String temp = "";
            // Once character matches start, iterate over string
            for (int j = i; j < s.length(); j++) {
                char curr = s.charAt(j);
                temp += curr;

                // Exit once end is found
                if (curr == end) {
                    found = true;
                    result += temp;
                    temp = "";
                }
            }
        }

        // Return null if substring not found
        if (!found) return null;

        return result;
    }


    /*
    public static String encode(String text),
    which encodes an arbitrary text by first converting all upper case letters into lower case letters and then replacing each letter with its position number in the alphabet.
    Umlauts such as .ä' and .B' are to be treated as "ae" and ~ss" respectively.
    All characters that are not letters should be ignored.
     */
    /**
     * Takes {@code text} into lowercase and replaces each letter with its
     * numerical position in the alphabet.
     *
     * Umlauts are converted to their English counterparts.
     *
     * @param text
     * @return {@code String} encoded text
     */
    // java ch6.Statics "äzXyä" => 1526242515
    // java ch6.Statics "äzbcä" => 15262315
    public static String encode(String text) {
        // Take text into lowercase
        text = text.toLowerCase();

        // Replace all umlauts
        text = text.replace("ä", "ae");
        text = text.replace("ß", "ss");
        text = text.replace("ü", "ue");
        text = text.replace("ö", "oe");

        // Iterate over each letter replacing it with equivalent numerical position in the alphabet
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            result += numericValueOf(text.charAt(i));
        }

        return result;
    }

    public static int numericValueOf(char currentChar) {
        return currentChar - 'a' + 1;
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

    public static String[] extractVariant(String text, String delim) {
        Hashtable<String, Integer> buffer = new Hashtable<>();
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
                // Increment count if word already exists, else add to the buffer
                buffer = bufferAdd(buffer, word);
                word = "";
            } else {
                word += temp;
            }
        }

        buffer = bufferAdd(buffer, word);

        String[] result = new String[buffer.size()];
        int i = 0;
        for (String key: buffer.keySet()) {
            result[i] = String.format("%s: %d", key, buffer.get(key));
            i++;
        }

        return result;

    }

    private static Hashtable<String, Integer> bufferAdd(Hashtable<String, Integer> buffer, String word) {
        word = word.trim();
        if(word.length() > 0) {
            if (buffer.containsKey(word)) {
                int count = buffer.get(word) + 1;
                buffer.replace(word, count);
            } else {
                buffer.put(word, 1);
            }
        }

        return buffer;
    }
}

