package com.surmize.textalytics;

import org.junit.BeforeClass;
import org.junit.Test;

public class TextAnalyzerTest{

    static TextAnalyzer ta;

    @BeforeClass
    public static void initialize(){
        System.out.println("INSIDE BEFORE CLASS");
        ta = new TextAnalyzer();
    }

    @Test
    public void testAnalyzeNegativeText() throws Exception {
        String text1 = "Zynga, Inc. (NASDAQ: ZNGA) took a bit of a reality check this week. After a stellar prior week on news of preannounced earnings and on an acquisition, investors and analysts alike were a bit mixed as far as the outlook for the social gaming company. Now shares are close to where they started, all over again.\n" +
                "\n" +
                "\n" +
                "It is no secret that Zynga is a very controversial company, nor is it a secret that this is a battleground stock. The company has many bulls behind it and many bears betting against it. A pair of analyst calls from this last week only highlights the controversy here.\n" +
                "\n" +
                "BofA Merrill Lynch downgraded Zynga to Underperform from Neutral on Monday. The firm’s price target is $3.80 per share. The analyst team said that there is a lot of execution already priced in the stock. They even see risk to 2014 guidance and pointed out excessive valuations – Take-Two Interactive Inc. (Nasdaq: TTWO) trades at less than 1-times 2015 sales, Zynga at over 3-times.\n" +
                "\n" +
                "UBS has a very different take. The firm raised its rating to Buy from Neutral on Tuesday and boosted its price target up to $6 from $4. UBS thinks that Zynga’s core operation has stabilized. Other drivers are the cost cuts and the recent $527 million acquisition. UBS differs from Merrill Lynch, signaling that first quarter guidance and 2014 guidance will prove to be conservative.\n" +
                "\n" +
                "Zynga shares rose up to $4.40 from $3.56 two weeks ago on the company’s news-break. This last week brought a new 52-week high of $4.97, but shares were back down to $4.53 in late Friday trading. This stock has not given back its gains from the initial pop, but the stock is back to within about 3% of that adjusted level.";

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
    }


}
