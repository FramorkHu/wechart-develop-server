package com.wechart.service.support;

import com.wechart.message.send.Article;
import com.wechart.message.send.BaseSendMessage;
import com.wechart.message.send.NewsSendMessage;
import com.wechart.service.MessageProcessor;
import com.wechart.utils.MessageUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by huyan on 2016/10/20.
 */
public class ClickEventProcessor extends MessageProcessor {

    @Override
    protected BaseSendMessage doProcess(Map<String, String> requestMsg) {

        String eventKey = requestMsg.get("EventKey");
        NewsSendMessage sendMessage = new NewsSendMessage();

        sendMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        List<Article> articleList = new ArrayList<>();

        if ("oschina".equals(eventKey)){

            Article article = new Article();
            article.setDescription("oschina描述");
            article.setPicUrl("http://www.iteye.com/upload/top_picture/0000/0096/_75E71529-76C7-4F8A-9469-A0DC004258D1_.jpg?1473151920");
            article.setUrl("http://www.iteye.com");
            article.setTitle("Tmall");
            articleList.add(article);

            sendMessage.setArticles(articleList);
            sendMessage.setArticleCount(articleList.size());
        }

        return sendMessage;
    }
}
