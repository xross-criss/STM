package pl.morecraft.dev.bdb.rest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.morecraft.dev.bdb.dto.AuthorDTO;
import pl.morecraft.dev.bdb.service.AuthorService;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/author/")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService taskService) {
        this.authorService = taskService;
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AuthorDTO> getAuthor(@RequestParam(value = "id") Integer id) throws IOException {
        return new ResponseEntity<>(
                authorService.getAuthor(id),
                HttpStatus.OK
        );
    }

    @RequestMapping(
            value = "",
            method = {RequestMethod.POST, RequestMethod.PUT},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AuthorDTO> saveTask(@ModelAttribute AuthorDTO author) throws IOException {
        return new ResponseEntity<>(
                authorService.saveAuthor(author),
                HttpStatus.OK
        );
    }

}
