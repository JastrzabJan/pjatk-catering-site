package pjatk.mas.project.cateringsite.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pjatk.mas.project.cateringsite.model.user.Administrator;
import pjatk.mas.project.cateringsite.repository.user.UserRepository;

@Service
@Transactional
public class AdministratorServiceImpl extends GenericUserServiceImpl<Administrator> implements AdministratorService {

    public AdministratorServiceImpl(UserRepository<Administrator> userRepository) {
        super(userRepository);
    }
}
