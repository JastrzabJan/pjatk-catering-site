package pjatk.mas.project.cateringsite.model.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@NoArgsConstructor
public class Role {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @NotBlank(message = "Role name cannot be blank or null")
    @Getter
    @Setter
    @Column(unique = true)
    private String name;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.REMOVE)
    private List<User> users;

    public Role(String name){
        this.name = name;
    }
}
