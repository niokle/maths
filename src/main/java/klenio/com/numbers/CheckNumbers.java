package klenio.com.numbers;

public class CheckNumbers {
    public static boolean isNumber(String string) {
        if (string.length() == 0) {
            return false;
        }
        return string.matches("[0-9]*");
    }

    public static boolean isNegative(String string) {
        if (string.length() > 0) {
            if (string.substring(0, 1).equals("-")) {
                return true;
            }
        }
        return false;
    }
}
