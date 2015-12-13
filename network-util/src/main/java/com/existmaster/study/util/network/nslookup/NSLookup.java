package com.existmaster.study.util.network.nslookup;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by existmaster on 2015. 12. 6..
 */
public class NSLookup {
    public InetAddress[] nslookup(String s) throws UnknownHostException {
        return InetAddress.getAllByName(s);
    }
}
