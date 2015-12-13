package com.existmaster.study.util.network.uriparser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by existmaster on 2015. 12. 6..
 */
public class URIParserTest {

    public static final String NORMAL_URL = "http://www.naver.com:8080/subdirectory";
    public static final String DEFAULT_PORT_URL = "http://www.naver.com/subdirectory";
    private URIParser URIParser;
    private URIModel URIModel;


    @Before
    public void setUp() throws Exception {
        URIParser = new URIParser();

    }

    @Test
    public void Test_ParseFunction(){
        URIModel = URIParser.parseUrl(NORMAL_URL);
        assertEquals(NetworkProtocol.HTTP, URIModel.getProtocol());
        assertEquals("www.naver.com", URIModel.getHost());
        assertEquals("8080", URIModel.getPort());
        assertEquals("subdirectory", URIModel.getSub());
    }

    @Test
    public void substring() {
        String s = "abcdaefghc";
        System.out.println(s.indexOf("cd"));
    }

    @Test
    public void DefaultPort(){
        URIModel = URIParser.parseUrl(DEFAULT_PORT_URL);
        assertEquals("www.naver.com", URIModel.getHost());
        assertEquals("80", URIModel.getPort());

    }
    @Test
    public void URLCheck_WrongValues_ExpectedException(){
        wrongValues_check("http2://www.naver.com:8080/subdir");
        wrongValues_check("http://:8080/sub");
        wrongValues_check("http:/www.naver.com:8080/sub");
    }

    public void wrongValues_check(String url) {
        try {
            URIParser.parseUrl(url);
        }
        catch(AssertionError e){
            return;
        }
        fail();
    }

}
