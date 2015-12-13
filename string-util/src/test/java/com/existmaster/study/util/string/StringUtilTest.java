package com.existmaster.study.util.string;

import org.junit.Before;
import org.junit.Test;
import sun.util.resources.CalendarData_ar;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created by existmaster on 2015. 12. 6..
 */
public class StringUtilTest {
    

    @Test
    public void inputvalue(){
        assertEquals("0012", StringUtil.convertIntToString(12, 4));
        assertEquals("00000350", StringUtil.convertIntToString(350, 8));
    }

    @Test
    public void InputWrongValue(){
        wrongValueCheck(350, 2);
    }

    private void wrongValueCheck(int value, int digit) {
        try{
            StringUtil.convertIntToString(value, digit);
            fail();
        }catch (IllegalArgumentException e){
            return;
        }
    }

    @Test
    public void ReplaceText(){
        assertEquals("ab22efg", StringUtil.replaceText("abcdefg", "cd", "22"));
        assertEquals("abefg", StringUtil.replaceText("abcdefg", "cd", ""));
        assertEquals("cccd",StringUtil.replaceText("abcd", "ab", "cc"));
        assertEquals("cdcdcd", StringUtil.replaceText("ababab", "ab", "cd"));
        assertEquals("abc", StringUtil.replaceText("abc", "33", "dd"));
    }

    @Test
    public void getDate(){
        Calendar calendar = new GregorianCalendar();
        calendar.set(2015,Calendar.DECEMBER,13,15,30,12);

        String result = StringUtil.getDate(calendar, "yyyy-MM-dd hh:mm:ss");

        assertNotNull(result);
        assertThat(result, is("2015-12-13 15:30:12"));

    }

    @Test
    public void getDateWithAMPM(){
        Calendar calendar = new GregorianCalendar();
        calendar.set(2015,Calendar.DECEMBER,13,15,30,12);

        String result = StringUtil.getDate(calendar, "yyyy-MM-dd hh:mm:ss(aa)");

        assertNotNull(result);
        assertThat(result, is("2015-12-13 03:30:12(오후)"));
    }
}
