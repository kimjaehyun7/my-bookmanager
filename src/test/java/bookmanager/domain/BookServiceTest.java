package bookmanager.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    BookService service;
    BookRepository repository;

    @BeforeEach
    void setUp() {
        repository = new BookRepository();
        service = new BookService(repository);
    }

    @Test
    void 도서_등록_테스트() {
        service.registerBook("도서", "저자");
        Book byId = repository.findById(1L);
        assertEquals("도서",byId.getTitle());
        assertEquals("저자",byId.getAuthor());
    }

    @Test
    void 모든_도서_조회_테스트() {
        service.registerBook("도서1", "저자1");
        service.registerBook("도서2", "저자2");
        service.registerBook("도서3", "저자3");
        List<Book> books = service.getBooks();
        assertEquals(3, books.size());
    }

    @Test
    void 도서_검색_테스트() {
        service.registerBook("도서1", "저자1");
        service.registerBook("도서2", "저자2");
        service.registerBook("도서3", "저자2");
        List<Book> searched = service.searchBooks("저자2");
        assertEquals(2, searched.size());
    }

    @Test
    void 도서_삭제_테스트() {
        service.registerBook("도서1", "저자1");
        service.registerBook("도서2", "저자2");
        service.registerBook("도서3", "저자3");
        service.deleteBook(2L);
        Book byId = repository.findById(2L);
        assertNull(byId);
    }

    @Test
    void 도서_대여_반납_테스트() {
        service.registerBook("도서", "저자");
        Book byId = repository.findById(1L);
        service.borrowBook(1L);
        assertTrue(byId.isBorrowed());
        service.returnBook(1L);
        assertFalse(byId.isBorrowed());
    }

    @Test
    void 도서_중복_등록_예외() {
        service.registerBook("도서", "저자");
        assertThrows(IllegalArgumentException.class, () -> service.registerBook("도서", "저자"));
    }

    @Test
    void 존재하지_않는_ID로_도서_삭제_예외() {
        service.registerBook("도서", "저자");
        assertThrows(NoSuchElementException.class, () -> service.deleteBook(2L));
    }

    @Test
    void 존재하지_않는_ID로_도서_대여_반납_예외() {
        service.registerBook("도서", "저자");
        assertThrows(NoSuchElementException.class, () -> service.borrowBook(2L));
        assertThrows(NoSuchElementException.class, () -> service.returnBook(2L));
    }

    @Test
    void 이미_대출된_도서를_대여시도_예외() {
        service.registerBook("도서", "저자");
        service.borrowBook(1L);
        assertThrows(IllegalStateException.class, () -> service.borrowBook(1L));
    }

    @Test
    void 대출되지_않은_도서를_반납_시도_예외() {
        service.registerBook("도서", "저자");
        assertThrows(IllegalStateException.class, () -> service.returnBook(1L));
    }
}