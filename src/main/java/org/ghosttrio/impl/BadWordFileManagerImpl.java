package org.ghosttrio.impl;

import org.ghosttrio.BadWordFileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BadWordFileManagerImpl implements BadWordFileManager {

    @Override
    public Stream<String> readFile(String path) {
        try {
            return Files.lines(Paths.get(path));
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public Stream<String> readJson(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String content = reader.lines().collect(Collectors.joining());
            String jsonArray = content.substring(content.indexOf("[") + 1, content.indexOf("]"));
            return Stream.of(jsonArray.split(",\\s*"))
                    .map(s -> s.replaceAll("\"", "").trim());
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }
}
