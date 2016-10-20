package com.wechart.service.support;

import com.wechart.message.send.BaseSendMessage;
import com.wechart.message.send.TextSendMessage;
import com.wechart.service.MessageProcessor;
import com.wechart.utils.MessageUtil;

import java.util.Date;
import java.util.Map;

/**
 * Created by huyan on 2016/10/20.
 */
public class DefaultMessageProcessor extends MessageProcessor {

    @Override
    protected BaseSendMessage doProcess(Map<String, String> requestMsg) {
        return null;
    }
}
