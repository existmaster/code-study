package com.existmaster.study;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by existmaster on 2015. 12. 6..
 */
public class NetworkUtil {
    public InetAddress[] nslookup(String s) throws UnknownHostException {
        return InetAddress.getAllByName(s);
    }
}
