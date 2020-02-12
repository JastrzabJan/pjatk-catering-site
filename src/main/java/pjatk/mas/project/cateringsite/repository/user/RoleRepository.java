package pjatk.mas.project.cateringsite.repository.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pjatk.mas.project.cateringsite.model.user.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
