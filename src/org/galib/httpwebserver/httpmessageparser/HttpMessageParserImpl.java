package org.galib.httpwebserver.httpmessageparser;

import org.galib.httpwebserver.httpmessageparser.HttpMessageParser;
import org.galib.httpwebserver.httpmessages.HttpRequestMessage;

/**
 * Created by bakhtiar.galib on 2/24/15.
 */
public class HttpMessageParserImpl implements HttpMessageParser {

    @Override
    public HttpRequestMessage parseGetMessage(String message) {

        HttpRequestMessage httpRequestMessage = new HttpRequestMessage();
        String headerLines[] = message.split("\r\n");

        httpRequestMessage.setMethod(headerLines[0].split(" ")[0]);
        httpRequestMessage.setUrl(headerLines[0].split(" ")[1]);
        httpRequestMessage.setHttpProtocolVersion(headerLines[0].split(" ")[2]);
        httpRequestMessage.setHost(headerLines[1].split("Host: ")[1]);
        httpRequestMessage.setUserAgent(headerLines[2].split("User-Agent: ")[1]);
        httpRequestMessage.setAcceptLanguage(headerLines[4].split("Accept-Language: ")[1]);
        httpRequestMessage.setConnection(headerLines[6].split("Connection: ")[1]);

        return httpRequestMessage;
    }

    @Override
    public HttpRequestMessage parsePostMessage(String message) {

        HttpRequestMessage httpRequestMessage = new HttpRequestMessage();
        String headerLines[] = message.split("\r\n");

        httpRequestMessage.setMethod(headerLines[0].split(" ")[0]);
        httpRequestMessage.setUrl(headerLines[0].split(" ")[1]);
        httpRequestMessage.setHttpProtocolVersion(headerLines[0].split(" ")[2]);
        httpRequestMessage.setHost(headerLines[1].split("Host: ")[1]);
        httpRequestMessage.setUserAgent(headerLines[2].split("User-Agent: ")[1]);
        httpRequestMessage.setContentBody(headerLines[11]);


        return httpRequestMessage;
    }
}
