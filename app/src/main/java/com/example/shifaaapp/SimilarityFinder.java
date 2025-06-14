package com.example.shifaaapp;

import java.util.List;
import java.util.Map;

public class SimilarityFinder {

    public static String findMostSimilarSentence(String target, List<String> sentences) {
        List<String> targetTokens = TextSimilarity.tokenize(target);
        Map<CharSequence, Integer> targetVector = TextSimilarity.vectorize(targetTokens);

        double maxSimilarity = -1;
        String mostSimilarSentence = null;

        for (String sentence : sentences) {
            List<String> sentenceTokens = TextSimilarity.tokenize(sentence);
            Map<CharSequence, Integer> sentenceVector = TextSimilarity.vectorize(sentenceTokens);
            double similarity = TextSimilarity.computeCosineSimilarity(targetVector, sentenceVector);

            if (similarity > maxSimilarity) {
                maxSimilarity = similarity;
                mostSimilarSentence = sentence;
            }

        }
        if (mostSimilarSentence == "حالات الشرقان او الغصة")
        {
            return "";
        }

        return mostSimilarSentence;
    }
}
