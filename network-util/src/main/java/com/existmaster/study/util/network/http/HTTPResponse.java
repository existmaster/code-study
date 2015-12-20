package com.existmaster.study.util.network.http;

import java.util.List;
import java.util.Map;

/**
 * Created by existmaster on 2015. 12. 20..
 */
public class HTTPResponse {

    int responseCode;
    Map<String,List<String>> headers;
    String body;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
