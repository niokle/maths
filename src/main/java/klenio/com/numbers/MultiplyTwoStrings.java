package klenio.com.numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiplyTwoStrings {
    public static String multiply(String string1, String string2) {
        String result = "";
        int col = 0;
        int row = 0;
        int rowStartValue = 0;
        int colStartValue = 0;
        boolean rowStart = true;
        boolean colStart = true;
        Map<Integer, Line> lines = new HashMap<>();
        boolean newLine = true;
        int lineNo = -1;

        for (int i = 0; i < string1.length() * string2.length(); i++) {

            if (colStart) {
                colStartValue = col;
                colStart = false;
            }

            if (rowStart) {
                rowStartValue = row;
                rowStart = false;
            }

            if (newLine) {
                lineNo++;
                lines.put(lineNo, new Line());
                newLine = false;
            }

            lines.get(lineNo).addPoint(new Point(new Value(col, getDigitSortNegative(string1, col)), new Value(row, getDigitSortNegative(string2, row))));

            col += 1;
            row -= 1;

            if (row < 0) {
                row = rowStartValue + 1;
                rowStart = true;
                col = colStartValue;
                colStart = true;

                newLine = true;
            }

            if (row > string2.length() - 1) {
                row = rowStartValue;
                col = colStartValue + 1;
                colStart = true;

                newLine = true;
            }

            if (col > string1.length() - 1) {
                if (colStartValue + 1 == string1.length()) {
                    col = colStartValue;
                } else {
                    col = colStartValue + 1;
                }
                colStart = true;
                row = rowStartValue;

                newLine = true;
            }
        }

        int sumLineValues = 0;
        int restPreviousLine = 0;
        for (int i = 0; i < string1.length() + string2.length() - 1; i++) {
            sumLineValues = lines.get(i).getSumLineValues() + restPreviousLine;
            result = sumLineValues%10 + result;
            if (String.valueOf(sumLineValues).length() > 1) {
                restPreviousLine = Integer.parseInt(String.valueOf(sumLineValues).substring(0, String.valueOf(sumLineValues).length() - 1));
            } else {
                restPreviousLine = 0;
            }
        }
        return removeLeadingZeros(result);
    }

    public static int getDigitSortNegative(String string, int position) {
        return Integer.parseInt(string.substring(string.length() - 1 - position, string.length() - 1 - position + 1));
    }

    public static String removeLeadingZeros(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '0') {
                return string.substring(i);
            }
        }
        return "0";
    }
}

class Line {
    private List<Point> points = new ArrayList<>();

    public Line() {

    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public int getSumLineValues() {
        int result = 0;
        for (Point p : points) {
            result += p.getMultiply();
        }
        return result;
    }

}

class Point {
    private Value column;
    private Value row;

    public Point(Value column, Value row) {
        this.column = column;
        this.row = row;
    }

    public int getMultiply() {
        return column.getValue() * row.getValue();
    }
}

class Value {
    private int id;
    private int value;

    public Value(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}