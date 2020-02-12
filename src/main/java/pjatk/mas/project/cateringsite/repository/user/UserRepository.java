package pjatk.mas.project.cateringsite.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pjatk.mas.project.cateringsite.model.user.User;

import java.util.Optional;

@NoRepositoryBean
public interface UserRepository<T extends User> extends JpaRepository<T, Long> {

    Optional<T> findByUsername(String username);

}
