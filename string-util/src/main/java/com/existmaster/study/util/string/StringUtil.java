package com.existmaster.study.util.string;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;

/**
 * Created by existmaster on 2015. 12. 6..
 */
public class StringUtil {

    public static String convertIntToString(int value, int digit) {
        String result = Integer.toString(value);
        if (result.length() > digit) throw new IllegalArgumentException();

        while (result.length() < digit) {
            result = "0" + result;
        }

        return result;
    }

    public static String replaceText(String source, String searchText, String replaceText) {
        String result = "";
        int searchTextIndex;
        String source_back = source;
        while(source_back.contains(searchText)){
            searchTextIndex =  source_back.indexOf(searchText);
            String source_front = source_back.substring(0, searchTextIndex);
            source_back = source_back.substring(searchTextIndex + searchText.length());
            result = result + source_front + replaceText;
        }
        result += source_back;
        return result;
    }

    public static String getDate(Calendar calendar, String format) {
        String result = format;
        String workingText;

        result = replaceText(result,"yyyy",String.format("%04d", calendar.get(Calendar.YEAR)));
        result = replaceText(result,"MM", String.format("%02d", calendar.get(Calendar.MONTH)+1));
        result = replaceText(result,"dd", String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH)));


        if(result.contains("aa")) {
            result = replaceText(result, "hh", String.format("%02d", calendar.get(Calendar.HOUR)));
            if(calendar.get(Calendar.AM_PM) == Calendar.AM) workingText = "오전";
            else workingText = "오후";
            result = replaceText(result, "aa", workingText);
        }else {
            result = replaceText(result, "hh", String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY)));
        }

        result = replaceText(result,"mm", String.format("%02d", calendar.get(Calendar.MINUTE)));
        result = replaceText(result,"ss", String.format("%02d", calendar.get(Calendar.SECOND)));
        return result;
    }
}
