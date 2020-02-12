package pjatk.mas.project.cateringsite.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pjatk.mas.project.cateringsite.model.offer.Offer;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class OrderOffer {

    @EmbeddedId
    private OrderOfferPK orderOfferPK;

    public OrderOffer(Order order, Offer offer, BigDecimal quantity){
        orderOfferPK = new OrderOfferPK();
        this.orderOfferPK.setOrder(order);
        this.orderOfferPK.setOffer(offer);
        this.quantity = quantity;
    }

    @NotNull(message = "The Quantity cannot be null")
    @Getter
    @Setter
    private BigDecimal quantity;

    public Offer getOffer(){
        return this.orderOfferPK.getOffer();
    }

    @Transient
    public BigDecimal getTotalPrice(){
        return getOffer().getPrice().multiply(getQuantity());
    }
}
