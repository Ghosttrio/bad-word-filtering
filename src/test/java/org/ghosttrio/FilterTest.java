package org.ghosttrio;

import org.ghosttrio.config.BadWordFilterFactory;
import org.ghosttrio.util.BadWord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class FilterTest {

    private BadWordFilter badWordFilter;
    private BadWord badWord;

    @BeforeEach
    void setUp() {
        badWordFilter = BadWordFilterFactory.badWordFilter();
        badWord = BadWordFilterFactory.badWord();
    }

    @Test
    void 나쁜말을_검출하면_true를_반환한다() {
        boolean result = badWordFilter.booleanFilter("ㅅㅂ");
        assertTrue(result);
    }

    @Test
    void 나쁜말을_검출하지_못하면_false를_반환한다() {
        boolean result = badWordFilter.booleanFilter("안녕");
        assertFalse(result);
    }

    @Test
    void 나쁜말을_검출하면_Exception을_던진다() {
        assertThrows(IllegalArgumentException.class, () -> badWordFilter.exceptionFilter("ㅅㅂ"));
    }

    @Test
    void 나쁜말을_검출하지_못하면_아무것도_하지_않는다() {
        assertDoesNotThrow(() -> badWordFilter.exceptionFilter("안녕"));
    }

    @Test
    void 나쁜말을_검출하면_애스터리스크로_치환한다() {
        String result = badWordFilter.asteriskFilter("ㅅㅂ");
        assertEquals("**", result);
    }

    @Test
    void 나쁜말을_검출하지_못하면_그대로_리턴한다() {
        String result = badWordFilter.asteriskFilter("안녕");
        assertEquals("안녕", result);
    }

    @Test
    void 팩토리에서_의존성_주입으로_필터_기능이_정상_작동한다() {
        boolean trueResult = badWordFilter.booleanFilter("ㅅㅂ");
        boolean falseResult = badWordFilter.booleanFilter("안녕");
        assertTrue(trueResult);
        assertFalse(falseResult);
    }

    @Test
    void 애스터리스크_치환_테스트() {
        final String input = "ㅅㅂ";
        String asterisks = "*".repeat(input.length());
        boolean isBadWord = badWord.getBadWords()
                .anyMatch(word -> word.equals(input));
        if (isBadWord) {
            System.out.println(asterisks);
        }
    }

    @Test
    void 애스터리스크_필터_작동_테스트() {
        String result1 = badWordFilter.asteriskFilter("ㅅㅂ");
        String result2 = badWordFilter.asteriskFilter("ㅅㅂㅅㅂ");
        String result3 = badWordFilter.asteriskFilter("안녕하세요");
        String result4 = badWordFilter.asteriskFilter("안녕하세요ㅅㅂ");
        assertEquals("**", result1);
        assertEquals("****", result2);
        assertEquals("안녕하세요", result3);
        assertEquals("안녕하세요**", result4);
    }

    @Test
    void 공백_필터_작동_테스트() {
        String result1 = badWordFilter.blankFilter("ㅅㅂ");
        String result2 = badWordFilter.blankFilter("ㅅㅂㅅㅂ");
        String result3 = badWordFilter.blankFilter("안녕하세요");
        String result4 = badWordFilter.blankFilter("안녕ㅅㅂ하세요");
        assertEquals("  ", result1);
        assertEquals("    ", result2);
        assertEquals("안녕하세요", result3);
        assertEquals("안녕  하세요", result4);
    }

    @Test
    void 나쁜말을_감지하면_공백으로_치환한다() {
        String result = badWordFilter.blankFilter("ㅅㅂ");
        assertEquals("  ", result);
    }

    @Test
    void 나쁜말을_감지하지_못하면_아무것도_하지_않는다() {
        String result = badWordFilter.blankFilter("안녕");
        assertEquals("안녕", result);
    }

}
