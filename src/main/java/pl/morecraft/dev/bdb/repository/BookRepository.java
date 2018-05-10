package pl.morecraft.dev.bdb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.morecraft.dev.bdb.domain.Book;
import pl.morecraft.dev.bdb.domain.Category;

public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
}
