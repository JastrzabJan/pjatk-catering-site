package pjatk.mas.project.cateringsite.service.user;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import pjatk.mas.project.cateringsite.exception.ResourceNotFoundException;
import pjatk.mas.project.cateringsite.model.user.User;
import pjatk.mas.project.cateringsite.repository.user.UserRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Transactional
public class GenericUserServiceImpl<T extends User> implements UserService<T> {

    private final UserRepository<T> repository;

    public GenericUserServiceImpl(UserRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public @NotNull Iterable<T> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public T getUserById(long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public T getUserByUsername(@NotBlank(message = "Username cannot be blank") String username) {
        return this.repository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public T save(@Valid T user) {
        return this.repository.save(user);
    }

    @Override
    public void delete(@Valid T offer) {
        this.repository.delete(offer);
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        T user = repository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Email " + userName + " not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                getAuthorities(user));    }

    private Collection<? extends GrantedAuthority> getAuthorities(T user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }

}
