package com.existmaster.study.util.network.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by existmaster on 2015. 12. 20..
 */
public class HttpUtil {
    public static HTTPResponse viewContentsFromURL(String url) throws Exception{
        URL u;
        HTTPResponse hr = new HTTPResponse();
        u = new URL(url);

        HttpURLConnection con = (HttpURLConnection) u.openConnection();
        con.setRequestMethod("GET");

        hr.setResponseCode(con.getResponseCode());
        hr.setHeaders(con.getHeaderFields());

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();

        hr.setBody(response.toString());
        return hr;
    }

}
