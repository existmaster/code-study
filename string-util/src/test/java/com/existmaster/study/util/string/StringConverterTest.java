package com.existmaster.study.util.string;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by existmaster on 2015. 12. 13..
 */
public class StringConverterTest {

    @Test
    public void int_to_Hex_String(){

        int normal = 20;

        String result = StringConverter.intToHexString(normal);

        assertNotNull(result);
        assertThat(result, is("14"));

    }

    @Test
    public void Add_Hex_Decoration(){

        String normal = "14";

        String result = StringConverter.addHexDecoration(normal);

        assertNotNull(result);
        assertThat(result, is("0x14"));
    }

    @Test
    public void Hex_String_to_int(){

        String normal = "0x14";

        int result = StringConverter.hexStringToInt(normal);

        assertNotNull(result);
        assertThat(result, is(20));
    }
}
