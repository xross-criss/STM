package pl.morecraft.dev.stm.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.morecraft.dev.stm.domain.Category;
import pl.morecraft.dev.stm.dto.CategoryDTO;
import pl.morecraft.dev.stm.exception.ObjectNotFoundException;
import pl.morecraft.dev.stm.repository.CategoryRepository;


import java.util.Objects;

@Slf4j
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO getCategory(Long id) {
        Category category = categoryRepository.findOne(id);
        if (Objects.isNull(category)) {
            throw new ObjectNotFoundException("Category with id=" + id + " not found");
        }

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(category, CategoryDTO.class);
    }

    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Category category = modelMapper.map(categoryDTO, Category.class);


        log.debug("Saving Task: " + categoryDTO.toString());
        category = categoryRepository.save(category);

        return modelMapper.map(category, CategoryDTO.class);
    }

}
