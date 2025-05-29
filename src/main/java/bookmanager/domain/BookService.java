package bookmanager.domain;

import java.util.List;
import java.util.NoSuchElementException;

public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void registerBook(String title, String author) {
        if (repository.isDuplicated(title, author)) {
            throw new IllegalArgumentException("이미 등록된 도서입니다.");
        }
        repository.save(new Book(title, author));
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public List<Book> searchBooks(String keyword) {
        return repository.findByKeyword(keyword);
    }

    public void deleteBook(Long id) {
        if (repository.findById(id) == null) {
            throw new NoSuchElementException("존재하지 않는 ID 입니다.");
        }
        repository.deleteById(id);
    }

    public void borrowBook(Long id) {
    }

    public void returnBook(Long id) {
    }
}
