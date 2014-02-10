package com.surmize.textalytics;

import java.util.ArrayList;
import java.util.List;

public class AnalyzedSentence {
    private String text;
    private int sentiment; // 0, 1, 2, 3, 4  where 0 = very negative; 2 = neutral, 4 = very positive
    private List<NamedEntity> entities;

    public AnalyzedSentence() {
    }

    public AnalyzedSentence(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSentiment() {
        return sentiment;
    }

    public void setSentiment(int sentiment) {
        this.sentiment = sentiment;
    }

    public List<NamedEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<NamedEntity> entities) {
        this.entities = entities;
    }

    public void addEntity(NamedEntity entity){
        if(getEntities() == null){
            setEntities( new ArrayList<NamedEntity>());
        }
        getEntities().add(entity);
    }

}
