package pjatk.mas.project.cateringsite.service.user;

import pjatk.mas.project.cateringsite.model.user.Client;

import javax.validation.Valid;

public interface ClientService extends UserService<Client> {

    void updatePersonalData(@Valid Client client, String name, String surname);
}
