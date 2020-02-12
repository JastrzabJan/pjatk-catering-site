package pjatk.mas.project.cateringsite.service.order;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import pjatk.mas.project.cateringsite.model.offer.Diet;
import pjatk.mas.project.cateringsite.model.offer.OneTimeOffer;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Transactional
@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartServiceImpl implements CartService {

    private Map<Diet, Integer> diets = new HashMap<>();
    private Map<OneTimeOffer, Integer> oneTimeOffers = new HashMap<>();

    @Override
    public void addDiet(Diet diet) {
        if (diets.containsKey(diet)) {
            diets.replace(diet, diets.get(diet) + 1);
        } else {
            diets.put(diet, 1);
        }
    }

    @Override
    public void addOneTimeOffer(OneTimeOffer oneTimeOffer) {
        if (oneTimeOffers.containsKey(oneTimeOffer)) {
            oneTimeOffers.replace(oneTimeOffer, oneTimeOffers.get(oneTimeOffer) + 1);
        } else {
            oneTimeOffers.put(oneTimeOffer, 1);
        }
    }

    @Override
    public void removeDiet(Diet diet) {
        if (diets.containsKey(diet)) {
            if (diets.get(diet) > 1)
                diets.replace(diet, diets.get(diet) - 1);
            else if (diets.get(diet) == 1) {
                diets.remove(diet);
            }
        }
    }

    @Override
    public void removeOneTimeOffer(OneTimeOffer oneTimeOffer) {
        if (oneTimeOffers.containsKey(oneTimeOffer)) {
            if (oneTimeOffers.get(oneTimeOffer) > 1)
                oneTimeOffers.replace(oneTimeOffer, oneTimeOffers.get(oneTimeOffer) - 1);
            else if (oneTimeOffers.get(oneTimeOffer) == 1) {
                oneTimeOffers.remove(oneTimeOffer);
            }
        }
    }



    @Override
    public Map<Diet, Integer> getDietsInCart() {
        return Collections.unmodifiableMap(diets);
    }

    @Override
    public Map<OneTimeOffer, Integer> getOneTimeOffersInCart() {
        return Collections.unmodifiableMap(oneTimeOffers);
    }

    @Override
    public BigDecimal getTotal() {
        return diets.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .add(
                        oneTimeOffers.entrySet().stream()
                                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                                .reduce(BigDecimal::add)
                                .orElse(BigDecimal.ZERO)
                );
    }

    @Override
    public void emptyCart() {
        diets.clear();;
        oneTimeOffers.clear();
    }
}