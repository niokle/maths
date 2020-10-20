package klenio.com.numbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddTwoStrings {
    public static String add(String string1, String string2) {
        String result = "";
        int max = Integer.max(string1.length(), string2.length());
        List<Integer> string1list = Arrays.stream(string1.split("")).map(c -> Integer.valueOf(String.valueOf(c))).collect(Collectors.toList());
        List<Integer> string2list = Arrays.stream(string2.split("")).map(c -> Integer.valueOf(String.valueOf(c))).collect(Collectors.toList());
        int value = 0;
        int rest = 0;
        int tempRest = 0;
        int string1value = 0;
        int string2value = 0;
        for (int i = 0; i < max; i++) {
            if (string1list.size() - 1 - i < 0) {
                string1value = 0;
            } else {
                string1value = string1list.get(string1list.size() - 1 - i);
            }

            if (string2list.size() - 1 - i < 0) {
                string2value = 0;
            } else {
                string2value = string2list.get(string2list.size() - 1 - i);
            }

            value = (string1value + string2value + rest)%10;
            tempRest = (string1value + string2value + rest) - value;
            rest = tempRest / 10;

            result = value + result;
        }
        return result;
    }
}
