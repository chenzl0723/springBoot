package com.chenzl.domain;

/**
 * 服务器向浏览器传送消息，用该类进行传送
 * Created by chenzl on 2017/12/11.
 */
public class ChenzlResponse {
    private String responseMessage;

    public ChenzlResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
