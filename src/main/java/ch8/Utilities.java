package ch8;

public class Utilities {
    static int counter = 0;
    public static void show(Showable a) {
        a.show();
        counter++;
    }
}
