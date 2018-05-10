package pl.morecraft.dev.bdb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.morecraft.dev.bdb.domain.Author;
import pl.morecraft.dev.bdb.domain.Category;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Integer> {
}
