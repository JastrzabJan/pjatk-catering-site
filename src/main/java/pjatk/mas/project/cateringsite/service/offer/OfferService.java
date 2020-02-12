package pjatk.mas.project.cateringsite.service.offer;

import org.springframework.validation.annotation.Validated;
import pjatk.mas.project.cateringsite.model.offer.Offer;
import pjatk.mas.project.cateringsite.model.offer.OfferStatus;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;

@Validated
public interface OfferService<T extends Offer> {

    @NotNull Iterable<T> getAllOffers();

    T getOffer(@Min(value = 1L, message = "Invalid offer ID.") long id);

    T save(@Valid T offer);

    void delete(@Valid T offer);

    void update(@Valid T offer, @NotNull(message = "Update date cannot be null") Date date, @NotBlank(message = "Update description cannot be null or blank") String description,  OfferStatus offerStatus);

}
