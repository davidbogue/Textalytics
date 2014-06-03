Textalytics
===========

Sentiment Analysis and Entity Extraction using the Stanford Natural Language Processing CoreNLP toolset.

Usage:
```java
AnalyzedDocument doc = ta.analyze(text1);

for (AnalyzedSentence analyzedSentence : doc.getSentences()) {
    System.out.println(analyzedSentence.getText());
    System.out.println("Sentiment: " + analyzedSentence.getSentiment());
    if (analyzedSentence.getEntities() != null) {
        for (NamedEntity namedEntity : analyzedSentence.getEntities()) {
            System.out.println("Entity: " + namedEntity.getText() + " " + namedEntity.getType());
        }
    }
}
```
