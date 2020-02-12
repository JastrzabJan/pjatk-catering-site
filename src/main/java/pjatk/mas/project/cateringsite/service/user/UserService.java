package pjatk.mas.project.cateringsite.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import pjatk.mas.project.cateringsite.model.user.User;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Validated
public interface UserService<T extends User> extends UserDetailsService {

    @NotNull Iterable<T> getAllUsers();

    T getUserById(@Min(value = 1L, message = "Invalid user ID.") long id);

    T getUserByUsername(@NotBlank(message = "Username cannot be blank") String username);

    T save(@Valid T user);

    void delete(@Valid T offer);

}

