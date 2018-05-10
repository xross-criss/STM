package pl.morecraft.dev.bdb.rest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.morecraft.dev.bdb.domain.Author;
import pl.morecraft.dev.bdb.service.AuthorService;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService taskService) {
        this.authorService = taskService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Author> getAuthor() throws IOException {
        return authorService.getAuthorList();
    }

    @RequestMapping(value = "/{authorId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Author getAuthor(@PathVariable(value = "authorId") Integer authorId) throws IOException {
        return authorService.getAuthor(authorId);
    }
}
