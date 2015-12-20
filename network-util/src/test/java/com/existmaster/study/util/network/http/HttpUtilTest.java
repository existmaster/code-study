package com.existmaster.study.util.network.http;

import org.junit.Test;

/**
 * Created by existmaster on 2015. 12. 20..
 */
public class HttpUtilTest {

    @Test
    public void viewContentsTest() throws Exception{
        String url_string = "http://rgate.net";
        HTTPResponse httpResponse = HttpUtil.viewContentsFromURL(url_string);
        System.out.println(httpResponse.getHeaders().toString());
        System.out.println(httpResponse.getBody());
    }

    @Test
    public void viewImageContentsTest() throws Exception{
        String url_string = "http://freestory.net/wp/wp-content/uploads/2015/03/docker012.png";
        HTTPResponse httpResponse = HttpUtil.viewContentsFromURL(url_string);
        System.out.println(httpResponse.getHeaders().toString());
        System.out.println(httpResponse.getBody());
    }
}
