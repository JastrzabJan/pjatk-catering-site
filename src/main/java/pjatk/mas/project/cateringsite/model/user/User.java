package pjatk.mas.project.cateringsite.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public abstract class User {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Getter
    @Setter
    @NotBlank(message = "User name is required")
    @Basic(optional = false)
    private String name;

    @Setter
    @Getter
    @NotBlank(message = "User surname is required")
    @Basic(optional = false)
    private String surname;

    @Setter
    @Getter
    @Temporal(TemporalType.DATE)
    @NotNull(message = "User birth date is required")
    private Date birthDate;


    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    @NotNull(message = "Gender cannot be null")
    private Gender gender;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Account status cannot be null")
    private AccountStatus accountStatus;

    @Getter
    @Setter
    @NotBlank(message = "Username cannot be null or blank")
    @Basic(optional = false)
    @Column(name= "username", unique = true)
    private String username;

    @Getter
    @Setter
    @NotBlank(message = "Username cannot be null or blank")
    @Basic(optional = false)
    private String password;

    @Transient
    public int getAge(){
        return 1;
    }

    @ManyToMany(cascade = CascadeType.REMOVE)
    @Getter
    @Setter
    private List<Role> roles;

    public User(String name, String surname, Date birthDate, Gender gender, AccountStatus accountStatus, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.accountStatus = accountStatus;
        this.username = username;
        this.password = encodePassword(password);
    }

    private String encodePassword(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}
