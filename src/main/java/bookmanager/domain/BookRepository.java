package bookmanager.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {

    private final Map<Long, Book> store = new HashMap<>();
    private Long sequence = 0L;

    public void save(Book book) {
        book.setId(++sequence);
        store.put(book.getId(), book);
    }

    public Book findById(Long id) {
        return null;
    }

    public List<Book> findAll() {
        return null;
    }

    public List<Book> findByKeyword(String keyword) {
        return null;
    }

    public void deleteById(Long id) {
    }

    public boolean isDuplicated(String title, String author) {
        return store.values().stream()
                .anyMatch(book -> book.getTitle().equals(title) &&
                        book.getAuthor().equals(author));
    }
}
