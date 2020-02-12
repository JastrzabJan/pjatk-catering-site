package pjatk.mas.project.cateringsite.service.user;

import pjatk.mas.project.cateringsite.model.user.Role;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public interface RoleService  {

    @NotNull Iterable getAllRoles();

    Role getRole(@Min(value = 1L, message = "Invalid role ID.") long id);

    Role save(@Valid Role role);

    void delete(@Valid Role role);
}
