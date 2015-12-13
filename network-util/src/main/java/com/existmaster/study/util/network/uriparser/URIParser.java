package com.existmaster.study.util.network.uriparser;

/**
 * Created by existmaster on 2015. 12. 6..
 */
public class URIParser extends AURIParser {

    public static final String PROTOCOL_DIVIDER = "://";
    public static final String HOST_DEVIDER = "/";
    public static final String PORT_DEVIDER = ":";

    @Override
    public URIModel parseUrl(String url) {
        URIModel URIModel = new URIModel(url);
        parseProtocol(URIModel);
        parseHostAndPort(URIModel);
        parseSubDirectory(URIModel);
        return URIModel;
    }

    private void parseProtocol(URIModel URIModel) {
        int url_start_index = 0;
        int url_end_index = URIModel.getUrl().indexOf(PROTOCOL_DIVIDER);

        if (url_end_index == -1) throw new AssertionError();

        URIModel.setProtocol(NetworkProtocol.getProtocol(
                URIModel.getUrl().substring(url_start_index, url_end_index)));
    }

    private void parseHostAndPort(URIModel URIModel) {
        int host_start_index = URIModel.getUrl().indexOf(PROTOCOL_DIVIDER);
        int host_end_index = URIModel.getUrl().indexOf(HOST_DEVIDER, host_start_index+3);

        String fullhost = URIModel.getUrl().substring(host_start_index + PROTOCOL_DIVIDER.length(), host_end_index);

        if (fullhost.contains(PORT_DEVIDER)) {
            URIModel.setHost(fullhost.substring(0, fullhost.indexOf(PORT_DEVIDER)));
            URIModel.setPort(fullhost.substring(fullhost.indexOf(PORT_DEVIDER) + 1));
        } else {
            URIModel.setHost(fullhost);
            URIModel.setPort(URIModel.getProtocol().getDefaultPort());
        }

        if (host_start_index == -1) throw new AssertionError();
        if (URIModel.getHost().equals("")) throw new AssertionError("NotFoundHost");

    }

    private void parseSubDirectory(URIModel URIModel) {
        int host_start_index = URIModel.getUrl().indexOf(PROTOCOL_DIVIDER) + PROTOCOL_DIVIDER.length();
        int host_end_index = URIModel.getUrl().indexOf(HOST_DEVIDER, host_start_index);
        URIModel.setSub(URIModel.getUrl().substring(host_end_index + 1));
    }
}
