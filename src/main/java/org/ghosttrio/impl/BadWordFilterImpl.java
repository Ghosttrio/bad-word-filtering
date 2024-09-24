package org.ghosttrio.impl;

import org.ghosttrio.BadWordFileManager;
import org.ghosttrio.BadWordFilter;
import org.ghosttrio.config.BadWordFilterFactory;
import org.ghosttrio.util.BadWord;

public class BadWordFilterImpl implements BadWordFilter {

    private final BadWord badWord = BadWordFilterFactory.badWord();
    private final BadWordFileManager badWordFileManager = BadWordFilterFactory.badWordFileManager();

    @Override
    public boolean booleanFilter(String input) {
        return badWord.getBadWords()
                .anyMatch(input::contains);
    }

    @Override
    public boolean booleanFilter(String input, String path) {
        if (path.endsWith(".json")) {
            return badWordFileManager.readJson(path)
                    .anyMatch(input::contains);
        } else if (path.endsWith(".csv") || path.endsWith(".txt")) {
            return badWordFileManager.readFile(path)
                    .anyMatch(input::contains);
        } else {
            throw new UnsupportedOperationException("지원하지 않는 파일 형식입니다.");
        }
    }

    @Override
    public void exceptionFilter(String input) {
        boolean result = badWord.getBadWords().anyMatch(input::contains);
        if (result) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void exceptionFilter(String input, String path) {
        if (path.endsWith(".json")) {
            boolean result = badWordFileManager.readJson(path)
                    .anyMatch(input::contains);
            if (result) {
                throw new IllegalArgumentException();
            }
        } else if (path.endsWith(".csv") || path.endsWith(".txt")) {
            boolean result = badWordFileManager.readFile(path)
                    .anyMatch(input::contains);
            if (result) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new UnsupportedOperationException("지원하지 않는 파일 형식입니다.");
        }
    }

    @Override
    public String asteriskFilter(String input) {
        return badWord.getBadWords()
                .reduce(input, (result, word) -> result.replaceAll("(?i)" + word, "*".repeat(word.length())));
    }

    @Override
    public String asteriskFilter(String input, String path) {
        if (path.endsWith(".json")) {
            return badWordFileManager.readJson(path)
                    .reduce(input, (result, word) -> result.replaceAll("(?i)" + word, "*".repeat(word.length())));
        } else if (path.endsWith(".csv") || path.endsWith(".txt")) {
            return badWordFileManager.readFile(path)
                    .reduce(input, (result, word) -> result.replaceAll("(?i)" + word, "*".repeat(word.length())));
        } else {
            throw new UnsupportedOperationException("지원하지 않는 파일 형식입니다.");
        }
    }

    @Override
    public String blankFilter(String input) {
        return badWord.getBadWords()
                .reduce(input, (result, word) -> result.replaceAll("(?i)" + word, " ".repeat(word.length())));
    }

    @Override
    public String blankFilter(String input, String path) {
        if (path.endsWith(".json")) {
            return badWordFileManager.readJson(path)
                    .reduce(input, (result, word) -> result.replaceAll("(?i)" + word, " ".repeat(word.length())));
        } else if (path.endsWith(".csv") || path.endsWith(".txt")) {
            return badWordFileManager.readFile(path)
                    .reduce(input, (result, word) -> result.replaceAll("(?i)" + word, " ".repeat(word.length())));
        } else {
            throw new UnsupportedOperationException("지원하지 않는 파일 형식입니다.");
        }
    }

}
