package org.ghosttrio;

import java.util.stream.Stream;

public interface BadWordFileManager {
    // csv, txt, json
    Stream<String> readFile(String path);
    // json
    Stream<String> readJson(String path);
}
