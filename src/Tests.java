// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Tests {
    public static void main(String[] args) {
        System.out.println(delimitedString(args[0], args[1].charAt(0), args[2].toCharArray()[0]));
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
    public static String delimitedString( String s, char start, char end) {
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
}