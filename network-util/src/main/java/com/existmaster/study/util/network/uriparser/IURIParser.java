package com.existmaster.study.util.network.uriparser;

/**
 * Created by existmaster on 2015. 12. 6..
 */
public interface IURIParser<URL> extends IParser {
    URL parseUrl(String url);
}
