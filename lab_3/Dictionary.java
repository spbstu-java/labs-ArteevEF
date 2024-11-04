package Lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary () {
        dictionary = new HashMap<>();
    }

    public void fileReader (Path path) throws FileReadException,InvalidFileFormatException {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\|");
                if (words.length == 2) {
                    if ((words[0].trim( ).length()>0) & (words[1].trim( ).length()>0)) {
                        this.dictionary.put(words[0].trim( ), words[1].trim( ));
                    }
                    else throw new InvalidFileFormatException("Пустые ячейки");
                }
                else throw new InvalidFileFormatException("Нарушено правило формирования словаря");
            }
        } catch (IOException e) {
            throw new FileReadException("Файл не прочитан");
        }
    }

    public String getElem (String key) {
        return this.dictionary.get(key);
    }

    public boolean isItContained(String key) {
        return this.dictionary.containsKey(key);
    }
}