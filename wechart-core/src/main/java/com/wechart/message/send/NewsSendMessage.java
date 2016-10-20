package com.wechart.message.send;

import java.util.List;

/**
 * Created by huyan on 2016/10/20.
 */
public class NewsSendMessage extends BaseSendMessage {

    private int ArticleCount;

    private List<Article> Articles;


    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }
}
