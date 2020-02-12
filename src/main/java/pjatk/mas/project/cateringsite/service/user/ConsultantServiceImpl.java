package pjatk.mas.project.cateringsite.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pjatk.mas.project.cateringsite.model.user.Consultant;
import pjatk.mas.project.cateringsite.repository.user.UserRepository;

@Service
@Transactional
public class ConsultantServiceImpl extends GenericUserServiceImpl<Consultant> implements ConsultantService {

    public ConsultantServiceImpl(UserRepository<Consultant> userRepository) {
        super(userRepository);
    }
}
