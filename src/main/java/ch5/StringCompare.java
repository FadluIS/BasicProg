package ch5;

public class StringCompare {
    private final static int ITERATIONS = 1000;

    public static void main(String[] args) {
        System.out.println("Testing STRING");
        long timeString = System.currentTimeMillis();
        String testString = "";
        for (int i = 0; i < ITERATIONS; i++) {
            testString += 'x';
        }
        timeString = System.currentTimeMillis() - timeString;

        System.out.println("Testing STRINGBUILDER");
        long timeStringBuilder = System.currentTimeMillis();
        StringBuilder testStringBuilder = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            testStringBuilder.append('x');
        }
        timeStringBuilder = System.currentTimeMillis() - timeStringBuilder;

        System.out.println("Testing STRINGBUFFER");
        long timeStringBuffer = System.currentTimeMillis();
        StringBuffer testStringBuffer = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) {
            testStringBuffer.append('x');
        }
        timeStringBuffer = System.currentTimeMillis() - timeStringBuffer;

        System.out.format("%nTime Taken:%n%nString: %d%nStringBuilder: %d%nStringBuffer: %d%n", timeString, timeStringBuilder, timeStringBuffer);
    }
}
