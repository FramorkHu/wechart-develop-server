package com.wechart.service;

import com.wechart.service.support.ClickEventProcessor;
import com.wechart.service.support.DefaultMessageProcessor;
import com.wechart.service.support.SubscribeEventProcessor;
import com.wechart.service.support.TextMessageProcessor;
import com.wechart.utils.MessageUtil;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * Created by huyan on 2016/10/20.
 */
public class MessageProcessorFactory {


    public static MessageProcessor getMessageProcessor(Map<String, String> requestMsg){

        String msgType = requestMsg.get(MessageUtil.MSG_TYPE);

        if (StringUtils.isEmpty(msgType)){
            return null;
        }

        // 文本消息
        if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            return new TextMessageProcessor();

        }
        // 图片消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
            // TODO 图片消息
            return new DefaultMessageProcessor();
        }
        // 语音消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
            // TODO 语音消息
            return new DefaultMessageProcessor();
        }
        // 视频消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
            // TODO 视频消息
            return new DefaultMessageProcessor();
        }
        // 地理位置消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
            // TODO 地理位置消息
            return new DefaultMessageProcessor();
        }
        // 链接消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
            // TODO 链接消息
            return new DefaultMessageProcessor();
        }
        // 事件推送
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
            // 事件类型
            String eventType = requestMsg.get("Event");
            // 关注
            if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                return new SubscribeEventProcessor();
            }
            // 取消关注
            else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                // TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
            }
            // 扫描带参数二维码
            else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
                // TODO 处理扫描带参数二维码事件
            }
            // 上报地理位置
            else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                // TODO 处理上报地理位置事件
            }
            // 自定义菜单
            else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                // TODO 处理菜单点击事件
                return new ClickEventProcessor();
            }
        }

        return new DefaultMessageProcessor();
    }
}
