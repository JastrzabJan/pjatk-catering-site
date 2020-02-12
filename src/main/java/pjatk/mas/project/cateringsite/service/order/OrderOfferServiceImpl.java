package pjatk.mas.project.cateringsite.service.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pjatk.mas.project.cateringsite.model.order.OrderOffer;
import pjatk.mas.project.cateringsite.repository.order.OrderOfferRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Transactional
@AllArgsConstructor
public class OrderOfferServiceImpl implements OrderOfferService{

    private OrderOfferRepository repository;

    @Override
    public OrderOffer create(@NotNull(message = "The offers for order cannot be null") @Valid OrderOffer orderOffer) {
        return this.repository.save(orderOffer);
    }
}
