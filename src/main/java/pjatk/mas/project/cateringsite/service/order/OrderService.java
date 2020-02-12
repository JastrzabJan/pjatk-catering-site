package pjatk.mas.project.cateringsite.service.order;

import org.springframework.validation.annotation.Validated;
import pjatk.mas.project.cateringsite.model.offer.OfferUpdate;
import pjatk.mas.project.cateringsite.model.order.Order;
import pjatk.mas.project.cateringsite.model.order.OrderHistory;
import pjatk.mas.project.cateringsite.model.user.Client;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderService {

    @NotNull Iterable getAllOrders();

    Order getOrder(@Min(value = 1L, message = "Invalid offer ID.") long id);

    Order save(@Valid Order order);

    void delete(@Valid Order order);

    void update(@NotNull(message = "The order cannot be null.") @Valid Order order, @NotNull(message = "The Order History cannot be null") @Valid OrderHistory orderHistory);



//    boolean isCancelable()
}
