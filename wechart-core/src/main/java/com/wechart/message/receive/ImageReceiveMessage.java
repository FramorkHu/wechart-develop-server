package com.wechart.message.receive;

/**
 * Created by huyan on 2016/10/8.
 */
public class ImageReceiveMessage extends BaseReceiveMessage {

    private String picUrl;
    private String mediaId;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
