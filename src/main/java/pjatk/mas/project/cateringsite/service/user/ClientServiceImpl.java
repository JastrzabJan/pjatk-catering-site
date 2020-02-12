package pjatk.mas.project.cateringsite.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pjatk.mas.project.cateringsite.model.user.Client;
import pjatk.mas.project.cateringsite.repository.user.UserRepository;

@Service
@Transactional
public class ClientServiceImpl extends GenericUserServiceImpl<Client> implements ClientService {

    public ClientServiceImpl(UserRepository<Client> repository) {
        super(repository);
    }

    @Override
    public void updatePersonalData(Client client, String name, String surname) {
        client.setName(name);
        client.setSurname(surname);
    }
}
