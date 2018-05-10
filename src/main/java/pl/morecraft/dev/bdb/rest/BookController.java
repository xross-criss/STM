package pl.morecraft.dev.bdb.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.morecraft.dev.bdb.domain.Book;
import pl.morecraft.dev.bdb.service.BookService;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getAuthor() throws IOException {
        return bookService.getBookList();
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getAuthor(@PathVariable(value = "bookId") Integer bookId) throws IOException {
        return bookService.getBook(bookId);
    }

}
