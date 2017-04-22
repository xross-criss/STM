package pl.morecraft.dev.stm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.morecraft.dev.stm.domain.Project;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
}
