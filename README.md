# 도서 관리 시스템 (연습)

> 사용자가 도서를 등록, 조회, 검색, 삭제, 대여, 반납할 수 있는 콘솔 기반 애플리케이션.

---

## 기능 및 요구사항

### 1. 도서 등록
- 사용자는 도서의 제목과 저자를 입력해 도서를 등록할 수 있다.
- 제목 또는 저자가 비어 있는 경우 등록할 수 없다.
- 동일한 제목과 저자의 도서는 중복 등록할 수 없다.
### 2. 도서 목록 조회
- 등록된 모든 도서를 조회할 수 있다.
- 조회 시 도서 ID, 제목, 저자를 함께 출력한다.
- 도서 목록은 등록 순서대로 보여준다.
### 3. 도서 검색
- 사용자는 키워드로 도서를 검색할 수 있다.
- 제목 또는 저자에 키워드가 포함된 도서를 모두 보여준다.
### 4. 도서 삭제
- 사용자는 도서 ID를 입력해 도서를 삭제할 수 있다.
- 존재하지 않는 ID를 입력하면 삭제할 수 없다.
### 5. 도서 대여 / 반납
- 사용자는 도서를 대여하거나 반납할 수 있다.
- 이미 대여 중인 도서는 중복 대여할 수 없다.
- 반납하지 않은 도서는 삭제할 수 없다.
---

# 프로젝트 구조
```
src/
├── main/
│   └── java/
│       └── bookmanager/
│           ├── App.java
│           ├── controller/
│           │   └── BookManagerController.java 
│           ├── domain/ 
│           │   ├── Book.java 
│           │   ├── BookRepository.java
│           │   └── BookService.java
│           └── view/ 
│               ├── InputView.java
│               └── OutputView.java
└── test/
    └── java/
        └── bookmanager/
            └── domain/
                ├── BookRepositoryTest.java
                └── BookServiceTest.java
```