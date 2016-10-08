package com.wechart.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by huyan on 2016/10/8.
 */
public class ConfigLoader {

    private static Properties paramProperties = new Properties();

    static {
        try {
            paramProperties.load(ConfigLoader.class.getClassLoader().getResourceAsStream("config/parameter.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getParamValue(String key){
        return paramProperties.getProperty(key);
    }

}
