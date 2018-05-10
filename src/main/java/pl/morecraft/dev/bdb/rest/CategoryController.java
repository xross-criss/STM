package pl.morecraft.dev.bdb.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.morecraft.dev.bdb.dto.CategoryDTO;
import pl.morecraft.dev.bdb.service.CategoryService;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CategoryDTO> getAuthor(@RequestParam(value = "id") Integer id) throws IOException {
        return new ResponseEntity<>(
                categoryService.getCategory(id),
                HttpStatus.OK
        );
    }

    @RequestMapping(
            value = "",
            method = {RequestMethod.POST, RequestMethod.PUT},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CategoryDTO> saveTask(@ModelAttribute CategoryDTO category) throws IOException {
        return new ResponseEntity<>(
                categoryService.saveCategory(category),
                HttpStatus.OK
        );
    }
}
