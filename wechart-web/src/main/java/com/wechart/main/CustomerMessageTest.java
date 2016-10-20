package com.wechart.main;

import com.alibaba.fastjson.JSONObject;
import com.wechart.bean.pojo.Token;
import com.wechart.utils.CommonUtil;

/**
 * Created by huyan on 2016/10/20.
 */
public class CustomerMessageTest {

    public static void main(String[] args) {

        Token accessToken = CommonUtil.getToken("wxe91f349429853766","85022851115b01566e22e874fd619093");
        String jsonTextMsg ="{\n" +
                "    \"touser\":\"ozNaXwzn_nO6mxUcBCoue3idGOSY\",\n" +
                "    \"msgtype\":\"text\",\n" +
                "    \"text\":\n" +
                "    {\n" +
                "         \"content\":\"Hello World\"\n" +
                "    }\n" +
                "}";


        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken.getAccessToken();

        JSONObject object = CommonUtil.httpsRequest(url, "POST", jsonTextMsg);

        if (object!= null){
             int errorCode = object.getInteger("errcode");
            String errorMsg = object.getString("errmsg");

            if (0== errorCode){
                System.out.println("ok");
            } else {
                System.out.println(errorMsg);
            }
        }


    }
}
