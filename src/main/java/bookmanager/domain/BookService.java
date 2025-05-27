package bookmanager.domain;

import java.util.List;

public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void registerBook(String title, String author) {
    }

    public List<Book> getBooks() {
        return null;
    }

    public List<Book> searchBooks(String keyword) {
        return null;
    }

    public void deleteBook(Long id) {
    }

    public void borrowBook(Long id) {
    }

    public void returnBook(Long id) {
    }
}
