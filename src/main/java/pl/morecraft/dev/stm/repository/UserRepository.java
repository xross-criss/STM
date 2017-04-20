package pl.morecraft.dev.stm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.morecraft.dev.stm.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
