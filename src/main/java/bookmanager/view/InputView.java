package bookmanager.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static int readOption() {
        OutputView.printMainOption();
        int option = Integer.parseInt(input.nextLine());
        if (option < 0 || option > 5) {
            throw new IllegalArgumentException("0~5 사이의 옵션만 입력 가능합니다.");
        }
        return option;
    }

    public static String readTitle() {
        OutputView.printReadTitle();
        String input = InputView.input.nextLine().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("도서 제목은 공백일 수 없습니다.");
        }
        return input;
    }

    public static String readAuthor() {
        OutputView.printReadAuthor();
        String input = InputView.input.nextLine().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("도서 저자는 공백일 수 없습니다.");
        }
        return input;
    }

    public static int readBorrowReturn() {
        OutputView.printBorrowReturnOption();
        int option = Integer.parseInt(input.nextLine());
        if (option != 1 && option != 2) {
            throw new IllegalArgumentException("1 또는 2의 옵션만 입력 가능합니다.");
        }
        return option;
    }

    public static Long readBookId() {
        OutputView.printReadBookId();
        return Long.parseLong(input.nextLine());
    }

    public static String readKeyword() {
        OutputView.printReadKeyword();
        String input = InputView.input.nextLine().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("최소 한 글자 이상의 키워드를 입력해야 합니다.");
        }
        return input;
    }
}
