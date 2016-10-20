package com.wechart.service.support;

import com.wechart.message.send.BaseSendMessage;
import com.wechart.message.send.TextSendMessage;
import com.wechart.service.MessageProcessor;
import com.wechart.utils.ChatRobotUtil;
import com.wechart.utils.MessageUtil;

import java.util.Map;

/**
 * Created by huyan on 2016/10/20.
 */
public class TextMessageProcessor extends MessageProcessor {

    @Override
    protected BaseSendMessage doProcess(Map<String, String> requestMsg) {

        TextSendMessage sendMessage = new TextSendMessage();
        sendMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        String content = requestMsg.get("Content");
        String response = new ChatRobotUtil().chatting(content, requestMsg.get(MessageUtil.MSG_FROM_USER_NAME));
        sendMessage.setContent(response);

        return sendMessage;
    }

}
