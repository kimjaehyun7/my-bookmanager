package bookmanager.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {

    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    void 도서ID값_테스트() {
        Book book1 = new Book("도서1", "저자1");
        Book book2 = new Book("도서2", "저자2");

        bookRepository.save(book1);
        bookRepository.save(book2);

        assertEquals(1,book1.getId());
        assertEquals(2,book2.getId());
    }

    @Test
    void 도서_중복_등록_테스트() {
        Book book = new Book("도서", "저자");

        bookRepository.save(book);
        boolean duplicated = bookRepository.isDuplicated("도서", "저자");

        assertTrue(duplicated);
    }

    @Test
    void ID로_도서_찾기_테스트() {
        Book book1 = new Book("도서1", "저자1");
        Book book2 = new Book("도서2", "저자2");

        bookRepository.save(book1);
        bookRepository.save(book2);
        Book byId = bookRepository.findById(2L);

        assertEquals(2, byId.getId());
    }

    @Test
    void 모든_도서_찾기_테스트() {
        Book book1 = new Book("도서1", "저자1");
        Book book2 = new Book("도서2", "저자2");
        Book book3 = new Book("도서3", "저자3");

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        List<Book> books = bookRepository.findAll();

        assertEquals(3, books.size());
    }

    @Test
    void 키워드로_도서_찾기_테스트() {
        Book book1 = new Book("도서1", "저자1");
        Book book2 = new Book("도서2", "저자2");
        Book book3 = new Book("도서3", "저자1");

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        List<Book> byKeyword = bookRepository.findByKeyword("저자1");

        assertEquals(2, byKeyword.size());
    }

    @Test
    void 도서_삭제_테스트() {
        Book book1 = new Book("도서1", "저자1");
        Book book2 = new Book("도서2", "저자2");
        Book book3 = new Book("도서3", "저자3");

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.deleteById(2L);

        assertNull(bookRepository.findById(2L));
    }
}