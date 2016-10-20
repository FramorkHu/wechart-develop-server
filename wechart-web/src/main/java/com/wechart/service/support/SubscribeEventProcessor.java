package com.wechart.service.support;

import com.wechart.message.send.BaseSendMessage;
import com.wechart.message.send.TextSendMessage;
import com.wechart.service.MessageProcessor;
import com.wechart.utils.MessageUtil;

import java.util.Map;

/**
 * Created by huyan on 2016/10/20.
 */
public class SubscribeEventProcessor extends MessageProcessor {
    @Override
    protected BaseSendMessage doProcess(Map<String, String> requestMsg) {
        TextSendMessage sendMessage = new TextSendMessage();
        sendMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        sendMessage.setContent("谢谢您的关注！");
        return sendMessage;
    }
}
