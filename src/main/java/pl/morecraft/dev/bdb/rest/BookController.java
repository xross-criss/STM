package pl.morecraft.dev.bdb.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.morecraft.dev.bdb.dto.BookDTO;
import pl.morecraft.dev.bdb.service.BookService;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> getAuthor(@RequestParam(value = "bookId") Integer bookId) throws IOException {
        return new ResponseEntity<>(
                bookService.getBook(bookId),
                HttpStatus.OK
        );
    }

    @RequestMapping(
            value = "",
            method = {RequestMethod.POST, RequestMethod.PUT},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BookDTO> saveTask(@ModelAttribute BookDTO book) throws IOException {
        return new ResponseEntity<>(
                bookService.saveBook(book),
                HttpStatus.OK
        );
    }
}
