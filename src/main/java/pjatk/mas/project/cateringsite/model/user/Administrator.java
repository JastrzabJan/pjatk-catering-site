package pjatk.mas.project.cateringsite.model.user;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
public class Administrator extends User {

    public Administrator(String name, String surname, Date birthDate, Gender gender, AccountStatus accountStatus, String username, String password) {
        super(name, surname, birthDate, gender, accountStatus, username, password);
    }
}
