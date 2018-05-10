package pl.morecraft.dev.bdb.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.morecraft.dev.bdb.domain.Author;
import pl.morecraft.dev.bdb.domain.Category;
import pl.morecraft.dev.bdb.service.CategoryService;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getCategoryList() throws IOException {
        return categoryService.getCategoryList();
    }

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Category getCategory(@PathVariable(value = "categoryId") Integer categoryId) throws IOException {
        return categoryService.getCategory(categoryId);
    }
}
