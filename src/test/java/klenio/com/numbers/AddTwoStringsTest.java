package klenio.com.numbers;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class AddTwoStringsTest extends TestCase {

    @Test
    public void testAdd() {
        //given
        String string1_1 = "1234567890123456";
        String string2_1 = "212121212121";
        String string1_2 = "1234567890123456";
        String string2_2 = "1";
        String string1_3 = "0";
        String string2_3 = "0";
        String string1_4 = "11";
        String string2_4 = "1234567890";
        String string1_5 = "12345";
        String string2_5 = "54321";

        //when
        String result1 = AddTwoStrings.add(string1_1, string2_1);
        String result2 = AddTwoStrings.add(string1_2, string2_2);
        String result3 = AddTwoStrings.add(string1_3, string2_3);
        String result4 = AddTwoStrings.add(string1_4, string2_4);
        String result5 = AddTwoStrings.add(string1_5, string2_5);

        //then
        Assert.assertEquals("1234780011335577", result1);
        Assert.assertEquals("1234567890123457", result2);
        Assert.assertEquals("0", result3);
        Assert.assertEquals("1234567901", result4);
        Assert.assertEquals("66666", result5);
    }
}