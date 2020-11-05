package klenio.com.numbers;

import junit.framework.TestCase;
import org.junit.Assert;

public class CheckNumbersTest extends TestCase {

    public void testIsNumber() {
        //given
        String string1 = "58450435058734057430";
        String string2 = "0";
        String string3 = "58450435 058734057430";
        String string4 = "584504350g58734057430";
        String string5 = "";
        String string6 = " ";
        String string7 = "5_8";
        String string8 = "1.2";
        String string9 = "1,2";

        //when
        boolean result1 = CheckNumbers.isNumber(string1);
        boolean result2 = CheckNumbers.isNumber(string2);
        boolean result3 = CheckNumbers.isNumber(string3);
        boolean result4 = CheckNumbers.isNumber(string4);
        boolean result5 = CheckNumbers.isNumber(string5);
        boolean result6 = CheckNumbers.isNumber(string6);
        boolean result7 = CheckNumbers.isNumber(string7);
        boolean result8 = CheckNumbers.isNumber(string8);
        boolean result9 = CheckNumbers.isNumber(string9);

        //then
        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertFalse(result3);
        Assert.assertFalse(result4);
        Assert.assertFalse(result5);
        Assert.assertFalse(result6);
        Assert.assertFalse(result7);
        Assert.assertFalse(result8);
        Assert.assertFalse(result9);
    }

    public void testIsNegative() {
        //given
        String string1 = "-53454354354";
        String string2 = "-";
        String string3 = "+53454354354";
        String string4 = "5-3454354354";
        String string5 = "53454354354-";
        String string6 = "";
        String string7 = " -44344333443";
        String string8 = "  ";

        //when
        boolean result1 = CheckNumbers.isNegative(string1);
        boolean result2 = CheckNumbers.isNegative(string2);
        boolean result3 = CheckNumbers.isNegative(string3);
        boolean result4 = CheckNumbers.isNegative(string4);
        boolean result5 = CheckNumbers.isNegative(string5);
        boolean result6 = CheckNumbers.isNegative(string6);
        boolean result7 = CheckNumbers.isNegative(string7);
        boolean result8 = CheckNumbers.isNegative(string8);

        //then
        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertFalse(result3);
        Assert.assertFalse(result4);
        Assert.assertFalse(result5);
        Assert.assertFalse(result6);
        Assert.assertFalse(result7);
        Assert.assertFalse(result8);
    }
}