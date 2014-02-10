package com.surmize.textalytics;

import java.util.ArrayList;
import java.util.List;

public class AnalyzedDocument {
    List<AnalyzedSentence> sentences;
    int sentiment;

    public int getSentiment() {
        return sentiment;
    }

    public void setSentiment(int sentiment) {
        this.sentiment = sentiment;
    }

    public List<AnalyzedSentence> getSentences() {
        return sentences;
    }

    public void addSentence(AnalyzedSentence sentence){
        if(getSentences() == null){
            setSentences( new ArrayList<AnalyzedSentence>() );
        }
        getSentences().add(sentence);
    }

    public void setSentences(List<AnalyzedSentence> sentences) {
        this.sentences = sentences;
    }

}
