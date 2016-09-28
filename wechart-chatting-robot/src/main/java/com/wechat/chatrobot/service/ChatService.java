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
public class ChatService {

    private final static String APP_KEY = "CfrA3bYSzJvY";
    private final static String APP_SECRET = "hjfw0GFNqPnBR1PU0KXW";

    private final static String REALM = "xiaoi.com";
    private final static String METHOD = "POST";
    private final static String URL = "/robot/ask.do";
    private final static String PATH = "http://nlp.xiaoi.com/robot/ask.do";

    public String chatting(String question, String userId){
        return processChatting(question, userId);
    }


    private   String processChatting(String question, String userId) {


        byte[] b = new byte[20];
        new Random().nextBytes(b);
        String nonce = new String(Hex.encodeHex(b));
        String HA1 = DigestUtils.shaHex(StringUtils.join(new String[]{
                APP_KEY, REALM, APP_SECRET}, ":"));
        String HA2 = DigestUtils.shaHex(StringUtils.join(new String[] { METHOD,
                URL }, ":"));
        String sign = DigestUtils.shaHex(StringUtils.join(new String[] { HA1,
                nonce, HA2 }, ":"));

        String str = "稍后再试吧~";

        HttpClient hc = new HttpClient();
        PostMethod pm = new PostMethod(PATH);
        pm.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
        pm.addRequestHeader("X-Auth", "app_key=\""+APP_KEY+"\", nonce=\""
                + nonce + "\", signature=\"" + sign + "\"");
        pm.setParameter("platform", "weixin");
        pm.setParameter("type", "0");
        pm.setParameter("userId", userId);
        pm.setParameter("question", question);
        int re_code;
        try {
            re_code = hc.executeMethod(pm);
            if (re_code == 200) {
                str = pm.getResponseBodyAsString();
            }
        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }
}
