package pjatk.mas.project.cateringsite.service.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.validation.annotation.Validated;
import pjatk.mas.project.cateringsite.model.order.OrderOffer;
import pjatk.mas.project.cateringsite.model.order.OrderOfferPK;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderOfferService{

    OrderOffer create(@NotNull(message = "The offers for order cannot be null") @Valid OrderOffer orderOffer);

}
