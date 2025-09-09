package de.mathisneunzig.listformat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EntityFileWriter {

    public static void write(String filePath, String entityName, List<String> values, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            writer.write("[" + entityName + "]");
            writer.newLine();
            writer.write(String.valueOf(values.size()));
            writer.newLine();
            for (String value : values) {
                writer.write(value);
                writer.newLine();
            }
            writer.newLine(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}