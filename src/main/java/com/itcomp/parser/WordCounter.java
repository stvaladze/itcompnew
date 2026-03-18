package com.itcomp.parser;

import com.itcomp.logger.AppLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class WordCounter {

    private static final Logger logger =
            AppLogger.getLogger(WordCounter.class);

    public static void count(String inputPath, String outputPath) throws IOException {


        String text = Files.readString(Path.of(inputPath));

        Map<String, Integer> counts = new TreeMap<>();

        String[] words = text.toLowerCase().split("[^a-zA-Z']+");

        for (String word : words) {
            if (!word.isEmpty()) {
                counts.merge(word, 1, Integer::sum);
            }
        }

        StringBuilder result = new StringBuilder("word,count\n");

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            result.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }

        Files.writeString(Path.of(outputPath), result.toString());

        logger.info("Word count completed. Output: " + outputPath);
    }
}