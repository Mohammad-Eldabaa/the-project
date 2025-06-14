package com.example.shifaaapp;

import org.apache.commons.text.similarity.CosineSimilarity;

import java.util.*;
import java.util.stream.Collectors;

public class TextSimilarity {

    private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList(
            "و", "في", "على", "من", "إلى", "عن", "مع", "أن", "التي", "الذي", "هذا", "هذه", "هو", "جاله","هي","حصله"));

    public static List<String> tokenize(String text) {
        return Arrays.stream(text.split("\\s+"))
                .filter(word -> !STOP_WORDS.contains(word))
                .collect(Collectors.toList());
    }

    public static Map<CharSequence, Integer> vectorize(List<String> tokens) {
        Map<CharSequence, Integer> vector = new HashMap<>();
        for (String token : tokens) {
            vector.put(token, vector.getOrDefault(token, 0) + 1);
        }
        return vector;
    }

    public static double computeCosineSimilarity(Map<CharSequence, Integer> vec1, Map<CharSequence, Integer> vec2) {
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        return cosineSimilarity.cosineSimilarity(vec1, vec2);
    }
}

