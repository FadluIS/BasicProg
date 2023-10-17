package ch5;

public class Statics {
    public static void main(String[] args) {
//        System.out.println(delimitedString(args[0], args[1].charAt(0), args[2].toCharArray()[0]));
//        System.out.println(encode("äzXyä"));
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
}