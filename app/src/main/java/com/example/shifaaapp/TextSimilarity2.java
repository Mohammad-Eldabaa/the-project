package com.example.shifaaapp;

import org.apache.commons.text.similarity.CosineSimilarity;

import java.util.HashMap;
import java.util.Map;

public class TextSimilarity2 {


    public static Map<CharSequence, Integer> vectorize(String text) {
        char b = '1';
        Map<CharSequence, Integer> vector = new HashMap<>();
        for (char c : text.toCharArray()) {

            String charAsString = b+ String.valueOf(c) ;
            if (b != 1)
                vector.put(charAsString, vector.getOrDefault(charAsString, 0) + 1);

            b = c;
        }
        return vector;
    }

    public static double computeCosineSimilarity(Map<CharSequence, Integer> vec1, Map<CharSequence, Integer> vec2) {
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        return cosineSimilarity.cosineSimilarity(vec1, vec2);
    }
}
