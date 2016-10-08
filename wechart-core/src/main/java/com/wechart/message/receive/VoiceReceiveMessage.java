package com.wechart.message.receive;

/**
 * Created by huyan on 2016/10/8.
 */
public class VoiceReceiveMessage extends BaseReceiveMessage {

    private String mediaId;
    private String format;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
