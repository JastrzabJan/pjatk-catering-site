package pjatk.mas.project.cateringsite.model.user;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
public class Manager extends User {

    public Manager(String name, String surname, Date birthDate, Gender gender, AccountStatus accountStatus, String username, String password) {
        super(name, surname, birthDate, gender, accountStatus, username, password);
    }
}
