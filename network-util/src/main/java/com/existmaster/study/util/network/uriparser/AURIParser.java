package com.existmaster.study.util.network.uriparser;

/**
 * Created by existmaster on 2015. 12. 6..
 */
public abstract class AURIParser implements IURIParser<URIModel> {

    @Override
    public String getParserType() {
        return "URIParser";
    }

}
