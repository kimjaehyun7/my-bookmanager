package bookmanager;

import bookmanager.controller.BookManagerController;
import bookmanager.domain.BookRepository;
import bookmanager.domain.BookService;

public class App {
    public static void main(String[] args) {
        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);
        BookManagerController bc = new BookManagerController(service);
        bc.run();
    }
}