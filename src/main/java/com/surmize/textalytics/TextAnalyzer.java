package com.surmize.textalytics;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Properties;

import static edu.stanford.nlp.ling.CoreAnnotations.*;

public class TextAnalyzer {

    StanfordCoreNLP pipeline;

    public TextAnalyzer() {
        // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution
        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse, sentiment");
        pipeline = new StanfordCoreNLP(props);
    }


    public AnalyzedDocument analyze(String text) {
        AnalyzedDocument analyzedDocument = new AnalyzedDocument();

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);

        // these are all the sentences in this document
        // a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);

        int sentenceCount = 0;
        int totalSentiment = 0;
        for (CoreMap sentence : sentences) {
            AnalyzedSentence as = constructAnalyzedSentence(sentence);
            analyzedDocument.addSentence(as);
            sentenceCount++;
            totalSentiment += as.getSentiment();
        }
        if(sentenceCount>0){
            analyzedDocument.setSentiment(totalSentiment/sentenceCount);
        }
        return analyzedDocument;
    }

    private AnalyzedSentence constructAnalyzedSentence(CoreMap sentence) {
        AnalyzedSentence analyzedSentence = new AnalyzedSentence(sentence.toString());

        // a CoreLabel is a CoreMap with additional token-specific methods
        for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
            // this is the NER label of the token
            String ne = token.get(NamedEntityTagAnnotation.class);
            if (!StringUtils.equals("O", ne)) {
                String word = token.get(TextAnnotation.class);
                NamedEntity entity = new NamedEntity(word);
                entity.setType(ne);
                entity.setOffsetBegin(token.get(CharacterOffsetBeginAnnotation.class));
                entity.setOffsetEnd(token.get(CharacterOffsetEndAnnotation.class));
                analyzedSentence.addEntity(entity);
            }

        }

        // this is the parse tree of the current sentence
        Tree sentimentTree = sentence.get(SentimentCoreAnnotations.AnnotatedTree.class);
        int sentiment = RNNCoreAnnotations.getPredictedClass(sentimentTree);
        analyzedSentence.setSentiment(sentiment);
        return analyzedSentence;
    }

}
