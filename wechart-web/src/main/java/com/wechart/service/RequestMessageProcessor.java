package com.wechart.service;

import com.wechart.message.receive.TextReceiveMessage;
import com.wechart.message.send.BaseSendMessage;
import com.wechart.message.send.NewsSendMessage;
import com.wechart.message.send.TextSendMessage;
import com.wechart.utils.MessageUtil;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by huyan on 2016/10/8.
 */
public class RequestMessageProcessor {

    private static final Logger LOGGER = Logger.getLogger(RequestMessageProcessor.class);


    public String processRequest(HttpServletRequest request){

        String respXml = null;

        try {
            Map<String, String> requestMsg = MessageUtil.parseXml(request.getInputStream());

            MessageProcessor processor =
                    MessageProcessorFactory.getMessageProcessor(requestMsg);

            if (processor == null){
                return "";
            }

            BaseSendMessage sendMessage = processor.processMsg(requestMsg);

            respXml = MessageUtil.messageToXml(sendMessage);

        } catch (Exception e) {
            LOGGER.error("RequestMessageProcessor is error:", e);
        }


        return respXml;
    }

}
