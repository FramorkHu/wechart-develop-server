package com.wechart.event;

/**
 * Created by huyan on 2016/10/9.
 */
public class MenuEvent extends BaseEvent {

    private String EventKey;


    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
