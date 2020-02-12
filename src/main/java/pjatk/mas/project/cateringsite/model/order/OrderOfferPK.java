package pjatk.mas.project.cateringsite.model.order;

import lombok.Getter;
import lombok.Setter;
import pjatk.mas.project.cateringsite.model.offer.Offer;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class OrderOfferPK implements Serializable {

    @Getter
    @Setter
    @ManyToOne
    private Order order;

    @Getter
    @Setter
    @ManyToOne
    private Offer offer;
}
