package com.wechart.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wechart.menu.Menu;
import com.wechart.utils.CommonUtil;
import org.apache.log4j.Logger;

import java.lang.ref.PhantomReference;

/**
 * Created by huyan on 2016/10/8.
 */
public class MenuOperate {

    private static final Logger LOGGER = Logger.getLogger(MenuOperate.class);

    private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    private static final String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    public static boolean createMenu(Menu menu, String accessToken){

        String url = parseUrl(CREATE_MENU_URL, accessToken);
        String jsonMenu = JSON.toJSONString(menu);

        JSONObject result = CommonUtil.httpsRequest(url, "POST", jsonMenu);

        return getResult(result, "create");

    }


    public static String getMenu(String accessToken){

        String url = parseUrl(GET_MENU_URL, accessToken);

        JSONObject result = CommonUtil.httpsRequest(url, "GET", null);

        if (result != null){
            return result.toJSONString();
        }

        return null;
    }


    public static boolean deleteMenu(String accessToken){

        String url = parseUrl(DELETE_MENU_URL, accessToken);

        JSONObject result = CommonUtil.httpsRequest(url,"PUT", null);

        return getResult(result,"delete");
    }

    private static boolean getResult(JSONObject result, String operate){

        if (null != result){

            int errorCode = result.getInteger("errcode");
            String errorMessage = result.getString("errmsg");

            if (0 == errorCode){
                return true;
            } else {
                LOGGER.error(operate+"菜单失败 ["+errorCode+"]["+errorMessage+"]");
                return false;
            }
        }

        return false;
    }

    private static String parseUrl(String originalData, String accessToken){
        return originalData.replace("ACCESS_TOKEN", accessToken);
    }
}
