package pl.morecraft.dev.stm.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.morecraft.dev.stm.dto.CategoryDTO;
import pl.morecraft.dev.stm.dto.TaskDTO;
import pl.morecraft.dev.stm.service.CategoryService;
import pl.morecraft.dev.stm.service.TaskService;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/category")
public class CategoryResource {
    private final CategoryService categoryService;

    @Autowired
    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CategoryDTO> getCategory(@RequestParam(value = "id") Long id) throws IOException {
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

    public ResponseEntity<CategoryDTO> saveCategory(@ModelAttribute CategoryDTO category) throws IOException {
        return new ResponseEntity<>(
                categoryService.saveCategory(category),
                HttpStatus.OK
        );
    }

}
