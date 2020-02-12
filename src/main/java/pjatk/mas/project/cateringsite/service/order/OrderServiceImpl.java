package pjatk.mas.project.cateringsite.service.order;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pjatk.mas.project.cateringsite.exception.ResourceNotFoundException;
import pjatk.mas.project.cateringsite.model.order.Order;
import pjatk.mas.project.cateringsite.model.order.OrderHistory;
import pjatk.mas.project.cateringsite.model.user.Client;
import pjatk.mas.project.cateringsite.repository.order.OrderRepository;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    private OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }



    @Override
    public void update(Order order, OrderHistory orderHistory) {
        order.addOrderHistory(orderHistory);
        this.repository.save(order);
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return this.repository.findAll();
    }

    @Override
    public Order getOrder(@Min(value = 1L, message = "Invalid offer ID.") long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    @Override
    public Order save(@Valid Order order) {
        return this.repository.save(order);
    }

    @Override
    public void delete(@Valid Order order) {
        this.repository.delete(order);
    }

}
