package com.example.shifaaapp;

import java.util.List;
import java.util.Map;

public class SimilarityFinder2 {

    public static String findMostSimilarSentence(String target, List<String> sentences) {
        Map<CharSequence, Integer> targetVector = TextSimilarity2.vectorize(target);

        double maxSimilarity = -1;
        String mostSimilarSentence = null;

        for (String sentence : sentences) {
            Map<CharSequence, Integer> sentenceVector = TextSimilarity2.vectorize(sentence);
            double similarity = TextSimilarity2.computeCosineSimilarity(targetVector, sentenceVector);

            if (similarity > maxSimilarity) {
                maxSimilarity = similarity;
                mostSimilarSentence = sentence;
            }
        }

        return mostSimilarSentence;
    }
}
