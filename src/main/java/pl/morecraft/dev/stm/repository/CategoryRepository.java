package pl.morecraft.dev.stm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.morecraft.dev.stm.domain.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
