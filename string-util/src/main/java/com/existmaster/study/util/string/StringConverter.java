package com.existmaster.study.util.string;

import java.util.Objects;

/**
 * Created by existmaster on 2015. 12. 13..
 */
public class StringConverter {


    public static final String PREFIX_CODE = "0x";

    public static String intToHexString(int integer) {

        return Integer.toHexString(integer);
    }

    public static String addHexDecoration(String string) {

        return PREFIX_CODE + string;
    }

    public static int hexStringToInt(String string) {

        if(!Objects.equals(string.substring(0, 2), PREFIX_CODE))
            throw new IllegalArgumentException();
        return Integer.decode(string);

    }
}
