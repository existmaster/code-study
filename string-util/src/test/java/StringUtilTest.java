import com.existmaster.study.util.string.StringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by existmaster on 2015. 12. 6..
 */
public class StringUtilTest {

    private StringUtil stringUtil;

    @Before
    public void setUp() throws Exception {
        stringUtil = new StringUtil();

    }

    @Test
    public void inputvalue(){
        assertEquals("0012", stringUtil.convertIntToString(12, 4));
        assertEquals("00000350", stringUtil.convertIntToString(350, 8));
    }

    @Test
    public void InputWrongValue(){
        wrongValueCheck(350, 2);
    }

    private void wrongValueCheck(int value, int digit) {
        try{
            stringUtil.convertIntToString(value, digit);
            fail();
        }catch (IllegalArgumentException e){
            return;
        }
    }

    @Test
    public void ReplaceText(){
        assertEquals("ab22efg", stringUtil.replaceText("abcdefg", "cd", "22"));
        assertEquals("abefg", stringUtil.replaceText("abcdefg", "cd", ""));
        assertEquals("cccd",stringUtil.replaceText("abcd", "ab", "cc"));
        assertEquals("cdcdcd", stringUtil.replaceText("ababab", "ab", "cd"));
        assertEquals("abc", stringUtil.replaceText("abc", "33", "dd"));
    }

}
