package pjatk.mas.project.cateringsite.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pjatk.mas.project.cateringsite.model.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
