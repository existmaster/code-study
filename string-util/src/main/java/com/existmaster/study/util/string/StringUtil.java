package com.existmaster.study.util.string;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by existmaster on 2015. 12. 6..
 */
public class StringUtil {

    public String convertIntToString(int value, int digit) {
        String result = Integer.toString(value);
        if (result.length() > digit) throw new IllegalArgumentException();

        while (result.length() < digit) {
            result = "0" + result;
        }

        return result;
    }

    public String replaceText(String source, String searchText, String replaceText) {
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
}
