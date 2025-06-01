package bookmanager.controller;

import bookmanager.domain.Book;
import bookmanager.domain.BookService;
import bookmanager.view.InputView;
import bookmanager.view.OutputView;

import java.util.List;
import java.util.NoSuchElementException;

public class BookManagerController {

    BookService service;

    public BookManagerController(BookService service) {
        this.service = service;
    }

    public void run() {
        OutputView.printStartMessage();

        while (true) {
            try {
                int option = InputView.readOption();

                switch (option) {
                    case 1 -> registerBook();
                    case 2 -> showBooks();
                    case 3 -> searchBooks();
                    case 4 -> deleteBook();
                    case 5 -> borrowOrReturnBook();
                    case 0 -> {
                        OutputView.printExit();
                        return;
                    }
                }
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void registerBook() {
        String title = InputView.readTitle();
        String author = InputView.readAuthor();
        service.registerBook(title, author);
    }

    private void showBooks() {
        OutputView.printBooks(service.getBooks());
    }

    private void searchBooks() {
        String keyword = InputView.readKeyword();
        OutputView.printBooks(service.searchBooks(keyword));
    }

    private void deleteBook() {
        Long id = InputView.readBookId();
        service.deleteBook(id);
        OutputView.printDeleteBook();
    }

    private void borrowOrReturnBook() {
        int option = InputView.readBorrowReturn();
        if (option == 1) {
            Long id = InputView.readBookId();
            service.borrowBook(id);
            OutputView.printBorrowBook();
        } else if (option == 2) {
            Long id = InputView.readBookId();
            service.returnBook(id);
            OutputView.printReturnBook();
        }
    }
}
