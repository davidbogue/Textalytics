package com.surmize.textalytics;

public class NamedEntity {
    String text;
    int offsetBegin = 0;
    int offsetEnd = 0;
    String type;


    public NamedEntity(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getOffsetBegin() {
        return offsetBegin;
    }

    public void setOffsetBegin(int offsetBegin) {
        this.offsetBegin = offsetBegin;
    }

    public int getOffsetEnd() {
        return offsetEnd;
    }

    public void setOffsetEnd(int offsetEnd) {
        this.offsetEnd = offsetEnd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
