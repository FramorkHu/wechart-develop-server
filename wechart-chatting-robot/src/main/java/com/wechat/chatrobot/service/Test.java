package com.wechat.chatrobot.service;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.Random;

/**
 * Created by huyan on 2016/9/28.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(new ChatService().chatting("我成功了","aaa"));
    }

}
