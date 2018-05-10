package pl.morecraft.dev.bdb.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.morecraft.dev.bdb.dao.CategoryDAO;
import pl.morecraft.dev.bdb.domain.Category;

import java.util.List;

@Slf4j
@Service
public class CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }


    public List<Category> getCategoryList() {
        return categoryDAO.getAllCategories();
    }


    public Category getCategory(Integer categoryId) {
        return categoryDAO.getCategory(categoryId);
    }
}