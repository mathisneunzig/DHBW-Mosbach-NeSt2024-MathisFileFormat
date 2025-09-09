# DHBW-Mosbach-NeSt2024-MathisFileFormat
File format that I used as "databases" in my teens.

## Example

```
[vehicles]
5
MB O530
MB O530G
MAN A21
MAN NL202
MAN NG272

[bus]
2
101
MAN NL202

[bus]
2
102
MAN NG272
```

## Usage

```java
package de.mathisneunzig.listformat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String filePath = "data.txt";

        EntityFileWriter.write(filePath, "vehicles", Arrays.asList(
                "MB O530", "MB O530G", "MAN A21", "MAN NL202", "MAN NG272"
        ), false); 

        EntityFileWriter.write(filePath, "bus", Arrays.asList(
                "101", "MAN NL202"
        ), true); 

        EntityFileWriter.write(filePath, "bus", Arrays.asList(
                "102", "MAN NG272"
        ), true); 

        Map<String, List<List<String>>> data = EntityFileReader.read(filePath);

        for (Map.Entry<String, List<List<String>>> entry : data.entrySet()) {
            String entity = entry.getKey();
            List<List<String>> records = entry.getValue();

            System.out.println("Entity: " + entity);
            for (List<String> record : records) {
                System.out.println(" - " + record);
            }
        }
    }
}
```
