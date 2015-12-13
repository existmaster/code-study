package com.existmaster.study.util.string;

import static java.lang.Math.pow;

/**
 * Created by existmaster on 2015. 12. 13..
 */
public class StringConverter {


    public static String intToHexString(int integer) {

        return Integer.toHexString(integer);
    }

    public static String addHexDecoration(String string) {

        return "0x" + string;
    }
}
