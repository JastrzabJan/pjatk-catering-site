package pjatk.mas.project.cateringsite.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pjatk.mas.project.cateringsite.model.user.Manager;
import pjatk.mas.project.cateringsite.repository.user.UserRepository;

@Service
@Transactional
public class ManagerServiceImpl extends GenericUserServiceImpl<Manager> implements ManagerService {

    public ManagerServiceImpl(UserRepository<Manager> userRepository) {
        super(userRepository);
    }

}
