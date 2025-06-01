package bookmanager.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static int readOption() {
        OutputView.printMainOption();
        return Integer.parseInt(input.nextLine());
    }

    public static String readTitle() {
        OutputView.printReadTitle();
        return input.nextLine();
    }

    public static String readAuthor() {
        OutputView.printReadAuthor();
        return input.nextLine();
    }

    public static int readBorrowReturn() {
        OutputView.printBorrowReturnOption();
        return Integer.parseInt(input.nextLine());
    }

    public static Long readBookId() {
        OutputView.printReadBookId();
        return Long.parseLong(input.nextLine());
    }

    public static String readKeyword() {
        OutputView.printReadKeyword();
        return input.nextLine();
    }
}
