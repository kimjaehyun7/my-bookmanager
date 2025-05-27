package bookmanager.domain;

import java.util.List;

public class BookRepository {

    public void save(Book book) {
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

    public boolean idDuplicated(String title, String author) {
        return false;
    }
}
