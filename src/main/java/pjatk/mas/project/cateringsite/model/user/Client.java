package pjatk.mas.project.cateringsite.model.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pjatk.mas.project.cateringsite.model.order.Order;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Client extends User {

    @OneToMany(mappedBy = "client")
    @Getter
    @Setter
    private Set<Order> orders = new HashSet<>();

    @Setter
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long clientId;

    public Client(String name, String surname, Date birthDate, Gender gender, AccountStatus accountStatus, String username, String password) {
        super(name, surname, birthDate, gender, accountStatus, username, password);
    }

    public void addOrder(@Valid  Order order){
        this.orders.add(order);
    }
}
