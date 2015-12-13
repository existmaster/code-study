package com.existmaster.study.util.network.dataparser;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

/**
 * Created by existmaster on 2015. 12. 13..
 */
public class DataParserTest {

    @Test
    public void canParseNormalURI(){
        String uri = "name=윤성열&age=30&sex=male";
        Map<String, String> result = DataParser.parseData(uri, "&", "=");

        assertNotNull(result);
        assertThat(result.get("name"), is("윤성열"));
        assertThat(result.get("age"), is("30"));
        assertThat(result.get("sex"), is("male"));


    }
}
