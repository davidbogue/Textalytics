package com.surmize.textalytics;

public class NamedEntity {
    private String text;
    private int offsetBegin = 0;
    private int offsetEnd = 0;
    private String type;


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
