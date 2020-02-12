package pjatk.mas.project.cateringsite.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pjatk.mas.project.cateringsite.exception.ResourceNotFoundException;
import pjatk.mas.project.cateringsite.model.user.Role;
import pjatk.mas.project.cateringsite.repository.user.RoleRepository;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public @NotNull Iterable getAllRoles() {
        return this.repository.findAll();
    }

    @Override
    public Role getRole(@Min(value = 1L, message = "Invalid role ID.") long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
    }

    @Override
    public Role save(@Valid Role role) {
        return this.repository.save(role);
    }

    @Override
    public void delete(@Valid Role role) {
        this.repository.delete(role);
    }
}
