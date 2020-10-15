import junit.framework.TestCase;
import klenio.com.numbers.MultiplyTwoStrings;
import org.junit.Assert;
import org.junit.Test;

public class MultiplyTwoStringsTest extends TestCase {

    @Test
    public void testMultiply() {
        //given

        //when
        String value0 = MultiplyTwoStrings.multiply("0", "0");
        String value1 = MultiplyTwoStrings.multiply("25", "10");
        String value2 = MultiplyTwoStrings.multiply("0", "100");
        String value3 = MultiplyTwoStrings.multiply("2", "2");
        String value4 = MultiplyTwoStrings.multiply("1234", "5678");
        String value5 = MultiplyTwoStrings.multiply("12345678901234567890", "12345678901234567890");
        //then
        Assert.assertEquals("0", value0);
        Assert.assertEquals("250", value1);
        Assert.assertEquals("0", value2);
        Assert.assertEquals("4", value3);
        Assert.assertEquals("7006652", value4);
        Assert.assertEquals("152415787532388367501905199875019052100", value5);
    }
}