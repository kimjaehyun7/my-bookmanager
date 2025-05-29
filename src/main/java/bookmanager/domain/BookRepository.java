package bookmanager.domain;

import java.util.ArrayList;
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
        return store.get(id);
    }

    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }

    public List<Book> findByKeyword(String keyword) {
        return store.values().stream()
                .filter(book -> book.getTitle().contains(keyword) ||
                        book.getAuthor().contains(keyword))
                .toList();
    }

    public void deleteById(Long id) {
        store.remove(id);
    }

    public boolean isDuplicated(String title, String author) {
        return store.values().stream()
                .anyMatch(book -> book.getTitle().equals(title) &&
                        book.getAuthor().equals(author));
    }
}
