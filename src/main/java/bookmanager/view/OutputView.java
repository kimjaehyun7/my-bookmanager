package bookmanager.view;

import bookmanager.domain.Book;

import java.util.List;

public class OutputView {

    private static final String TITLE = "==================[도서 관리 시스템]==================";
    private static final String BOOKS = "======================[도서 목록]======================\n" +
            "ID | 제목                    | 저자         | 대여 여부 ";
    private static final String MAIN_OPTION = "[옵션] 1. 등록 2. 전제 조회 3. 검색 4. 삭제 5. 대여/반납 0. 종료";
    private static final String BORROW_RETURN_OPTION = "[옵션] 1. 대여 2. 반납";
    private static final String READ_OPTION = "옵션을 입력해주세요: ";
    private static final String READ_BOOK_TITLE = "도서 제목을 입력해주세요: ";
    private static final String READ_BOOK_AUTHOR = "도서 저자를 입력해주세요: ";
    private static final String READ_BOOK_ID = "도서 ID를 입력해주세요: ";
    private static final String READ_KEYWORD = "검색할 키워드를 입력해주세요: ";
    private static final String DELETE_BOOK = "[도서 삭제 완료]";
    private static final String RETURN_BOOK = "[도서 반납 완료]";
    private static final String BORROW_BOOK = "[도서 대여 완료]";
    private static final String EXIT = "프로그램을 종료합니다.";

    public static void printStartMessage() {
        System.out.println(TITLE);
    }

    public static void printMainOption() {
        System.out.println(MAIN_OPTION);
        System.out.print(READ_OPTION);
    }

    public static void printBorrowReturnOption() {
        System.out.println(BORROW_RETURN_OPTION);
        System.out.print(READ_OPTION);
    }

    public static void printReadTitle() {
        System.out.print(READ_BOOK_TITLE);
    }

    public static void printReadAuthor() {
        System.out.print(READ_BOOK_AUTHOR);
    }

    public static void printReadBookId() {
        System.out.print(READ_BOOK_ID);
    }

    public static void printReadKeyword() {
        System.out.print(READ_KEYWORD);
    }

    public static void printDeleteBook() {
        System.out.println(DELETE_BOOK);
    }

    public static void printBorrowBook() {
        System.out.println(BORROW_BOOK);
    }

    public static void printReturnBook() {
        System.out.println(RETURN_BOOK);
    }

    public static void printExit() {
        System.out.println(EXIT);
    }

    public static void printBooks(List<Book> books) {
        System.out.println(BOOKS);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void printErrorMessage(String message) {
        System.out.println("[오류 발생]: " + message);
    }
}
