package pl.morecraft.dev.bdb.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.morecraft.dev.bdb.dao.BookDAO;
import pl.morecraft.dev.bdb.domain.Book;

import java.util.List;

@Slf4j
@Service
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> getBookList() {
        return bookDAO.getAllBooks();
    }

    public Book getBook(Integer bookId) {
        return bookDAO.getBook(bookId);
    }
}
