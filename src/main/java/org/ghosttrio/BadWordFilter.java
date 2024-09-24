package org.ghosttrio;

public interface BadWordFilter {

    /**
     * 단어를 입력, 나쁜말을 boolean 값을 리턴하는 필터
     * @param input : 나쁜말
     * @return : 나쁜말이 검출되면 true, 검출되지 않으면 false
     */
    boolean booleanFilter(String input);

    /**
     * 단어를 입력, 나쁜말을 boolean 값을 리턴하는 필터
     * @param input : 나쁜말
     * @param path : 커스텀 나쁜말 CSV/TXT/JSON 파일 경로
     * @return : 나쁜말이 검출되면 true, 검출되지 않으면 false
     */
    boolean booleanFilter(String input, String path);

    /**
     * 단어를 입력, 나쁜말을 exception 값을 던지는 필터
     * @param input : 나쁜말
     * 나쁜말이 검출되면 IllegalArgumentException
     */
    void exceptionFilter(String input);

    /**
     * 단어를 입력, 나쁜말을 exception 값을 던지는 필터
     * @param input : 나쁜말
     * @param path : 커스텀 나쁜말 CSV/TXT/JSON 파일 경로
     * 나쁜말이 검출되면 IllegalArgumentException
     */
    void exceptionFilter(String input, String path);

    /**
     * 단어를 입력, 나쁜말을 애스터리스크(*)로 바꿔주는 필터
     * @param input : 나쁜말
     * @return : 나쁜말이 검출되면 애스터리스크(*) 처리
     */
    String asteriskFilter(String input);

    /**
     * 단어를 입력, 나쁜말을 애스터리스크(*)로 바꿔주는 필터
     * @param input : 나쁜말
     * @param path : 커스텀 나쁜말 CSV/TXT/JSON 파일 경로
     * @return : 나쁜말이 검출되면 애스터리스크(*) 처리
     */
    String asteriskFilter(String input, String path);

    /**
     * 단어를 입력, 나쁜말을 공백으로 바꿔주는 필터
     * @param input : 나쁜말
     * @return : 나쁜말이 검출되면 공백 처리
     */
    String blankFilter(String input);

    /**
     * 단어를 입력, 나쁜말을 공백으로 바꿔주는 필터
     * @param input : 나쁜말
     * @param path : 커스텀 나쁜말 CSV/TXT/JSON 파일 경로
     * @return : 나쁜말이 검출되면 공백 처리
     */
    String blankFilter(String input, String path);
}
