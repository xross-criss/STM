package pl.morecraft.dev.stm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.morecraft.dev.stm.domain.Task;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
}
