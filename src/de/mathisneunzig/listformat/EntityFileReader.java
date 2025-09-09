package de.mathisneunzig.listformat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class EntityFileReader {

    public static Map<String, List<List<String>>> read(String filePath) {
        Map<String, List<List<String>>> result = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                if (line.startsWith("[")) {
                    String entity = line.substring(1, line.length() - 1);
                    int count = Integer.parseInt(reader.readLine());
                    List<String> values = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        values.add(reader.readLine());
                    }

                    result.computeIfAbsent(entity, k -> new ArrayList<>()).add(values);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}