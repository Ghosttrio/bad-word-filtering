package org.ghosttrio.impl;

import org.ghosttrio.BadWordFilter;
import org.ghosttrio.config.BadWordFilterFactory;
import org.ghosttrio.util.BadWord;

public class BadWordFilterImpl implements BadWordFilter {

    private final BadWord badWord = BadWordFilterFactory.badWord();

    @Override
    public boolean booleanFilter(String input) {
        return badWord.getBadWords()
                .anyMatch(input::contains);
    }

    @Override
    public void exceptionFilter(String input) {
        boolean result = badWord.getBadWords().anyMatch(input::contains);
        if (result) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String asteriskFilter(String input) {
        return badWord.getBadWords()
                .reduce(input, (result, word) -> result.replaceAll("(?i)" + word, "*".repeat(word.length())));
    }

    @Override
    public String blankFilter(String input) {
        return badWord.getBadWords()
                .reduce(input, (result, word) -> result.replaceAll("(?i)" + word, " ".repeat(word.length())));
    }

}
