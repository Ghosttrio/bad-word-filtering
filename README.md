## 비속어 필터링 라이브러리

### 사용법

```java

BadWordFilter filter = BadWordFilterFactory.badWordFilter();
filter.booleanFilter("badword");

```
- csv, txt 파일은 줄바꿈으로 구분됩니다.
- json 형식
```json
{
  "badword": [
      "word1",
      "word2"
  ]
}
```


### 기능

- 단어를 입력하면 기본 설정 비속어 목록에 있는 값을 필터링하여 true/false 반환
- 단어와 CSV/TXT/JSON 파일 경로를 입력하면 기본 설정 비속어 목록에 있는 값을 필터링하여 true/false 반환
- 단어를 입력하면 기본 설정 비속어 목록에 있는 값을 필터링하여 exception 던짐
- 단어와 CSV/TXT/JSON 파일 경로를 입력하면 기본 설정 비속어 목록에 있는 값을 필터링하여 exception 던짐
- 단어를 입력하면 기본 설정 비속어 목록에 있는 값을 필터링하여 애스터리스크(*)로 치환
- 단어와 CSV/TXT/JSON 파일 경로를 입력하면 기본 설정 비속어 목록에 있는 값을 필터링하여 애스터리스크(*)로 전환
- 단어를 입력하면 기본 설정 비속어 목록에 있는 값을 필터링하여 공백으로 치환
- 단어와 CSV/TXT/JSON 파일 경로를 입력하면 기본 설정 비속어 목록에 있는 값을 필터링하여 공백으로 치환

### 인터페이스

```java

// json, txt, csv 이외의 파일은 UnsupportedOperationException

// 단어를 입력, 나쁜말을 boolean 값을 리턴하는 필터
// 검출 되면 true, 검출 되지 않으면 false
boolean booleanFilter(String input);

// 단어를 입력, CSV/TXT/JSON 파일 경로 입력, 나쁜말을 boolean 값을 리턴하는 필터
// 검출 되면 true, 검출 되지 않으면 false
boolean booleanFilter(String input, String path);

// 단어를 입력, 나쁜말을 exception 값을 던지는 필터
// @throws IllegalArgumentException
void exceptionFilter(String input);

// 단어를 입력, CSV/TXT/JSON 파일 경로 입력, 나쁜말을 exception 값을 던지는 필터
// @throws IllegalArgumentException
void exceptionFilter(String input, String path);

// 단어를 입력, 나쁜말을 애스터리스크(*)로 바꿔주는 필터
String asteriskFilter(String input);

// 단어를 입력, CSV/TXT/JSON 파일 경로 입력, 나쁜말을 애스터리스크(*)로 바꿔주는 필터
String asteriskFilter(String input, String path);

// 단어를 입력, 나쁜말을 공백으로 바꿔주는 필터
String blankFilter(String input);

// 단어를 입력, CSV/TXT/JSON 파일 경로 입력, 나쁜말을 공백으로 바꿔주는 필터
String blankFilter(String input, String path);

```
