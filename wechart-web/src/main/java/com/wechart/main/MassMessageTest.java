package com.wechart.main;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by huyan on 2016/10/20.
 */
public class MassMessageTest {

    public static void main(String[] args) {



    }

    private void uploadFile() throws IOException {

        String reqUrl = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";

        URL url = new URL(reqUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        // 设置请求方式（GET/POST）
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "multipart/form-data");

        OutputStream outputStream =
                conn.getOutputStream();
        URL imgUrl = new URL("");

    }
}
