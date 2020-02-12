package pjatk.mas.project.cateringsite.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pjatk.mas.project.cateringsite.model.user.Client;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "Order date cannot be null")
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    @NotNull(message = "Order status cannot be null")
    private OrderStatus orderStatus;

    @ElementCollection
    @Getter
    @Setter
    private Set<OrderHistory> orderHistory = new HashSet<>();

    @ManyToOne
    @Getter
    @Setter
    private Client client;

    @Embedded
    @Getter
    @Setter
    @NotNull(message = "Delivery form cannot be null")
    private DeliveryForm deliveryForm;

    @ManyToMany
    @Getter
    @Setter
    private Set<Report> reports = new HashSet<>();

    @OneToMany(mappedBy = "orderOfferPK.order", cascade = CascadeType.REMOVE)
    @Valid
    @Getter
    @Setter
    private List<OrderOffer> orderOfferList = new ArrayList<>();

    public void addOrderHistory(OrderHistory orderHistory){
        this.orderHistory.add(orderHistory);
    }

    public Order(Date orderDate, OrderStatus orderStatus, Client client, DeliveryForm deliveryForm) {
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.client = client;
        this.deliveryForm = deliveryForm;
    }
}
