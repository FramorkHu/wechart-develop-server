package com.wechart.service;

import com.wechart.message.send.BaseSendMessage;
import com.wechart.utils.MessageUtil;

import java.util.Date;
import java.util.Map;

/**
 * Created by huyan on 2016/10/20.
 */
public abstract class MessageProcessor {

    public BaseSendMessage processMsg(Map<String, String> requestMsg){

        String fromUserName = requestMsg.get(MessageUtil.MSG_FROM_USER_NAME);
        String toUserName = requestMsg.get(MessageUtil.MSG_TO_USER_NAME);

        BaseSendMessage baseSendMessage = doProcess(requestMsg);

        if (baseSendMessage != null){
            baseSendMessage.setFromUserName(toUserName);
            baseSendMessage.setToUserName(fromUserName);
            baseSendMessage.setCreateTime(new Date().getTime());
        }

        return baseSendMessage;
    }

     protected abstract BaseSendMessage doProcess(Map<String, String> requestMsg);

}
