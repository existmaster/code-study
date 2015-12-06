package com.existmaster.study;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by existmaster on 2015. 12. 6..
 */
public class NetworkUtil {
    public String nslookup(String s) throws UnknownHostException {
        return InetAddress.getByName(s).getHostAddress();
    }
}
