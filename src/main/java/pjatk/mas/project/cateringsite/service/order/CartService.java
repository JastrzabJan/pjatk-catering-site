package pjatk.mas.project.cateringsite.service.order;

import pjatk.mas.project.cateringsite.model.offer.Diet;
import pjatk.mas.project.cateringsite.model.offer.OneTimeOffer;

import java.math.BigDecimal;
import java.util.Map;

public interface CartService {

    void addDiet(Diet diet);
    void addOneTimeOffer(OneTimeOffer diet);

    void removeDiet(Diet diet);
    void removeOneTimeOffer(OneTimeOffer oneTimeOffer);

    Map<Diet, Integer> getDietsInCart();
    Map<OneTimeOffer, Integer> getOneTimeOffersInCart();

    BigDecimal getTotal();

    void emptyCart();

}
