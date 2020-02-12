package pjatk.mas.project.cateringsite.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pjatk.mas.project.cateringsite.model.order.OrderOffer;
import pjatk.mas.project.cateringsite.model.order.OrderOfferPK;

@Repository
public interface OrderOfferRepository extends JpaRepository<OrderOffer, OrderOfferPK> {

}
