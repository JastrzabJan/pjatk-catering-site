package pjatk.mas.project.cateringsite.service.offer;

import pjatk.mas.project.cateringsite.exception.ResourceNotFoundException;
import pjatk.mas.project.cateringsite.model.offer.Offer;
import pjatk.mas.project.cateringsite.model.offer.OfferStatus;
import pjatk.mas.project.cateringsite.model.offer.OfferUpdate;
import pjatk.mas.project.cateringsite.repository.offer.OfferRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;

public class GenericOfferServiceImpl<T extends Offer> implements  OfferService<T> {

    private final OfferRepository<T> repository;

    public GenericOfferServiceImpl(OfferRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public @NotNull Iterable<T> getAllOffers() {
        return repository.findAll();
    }

    @Override
    public T getOffer(@Min(value = 1L, message = "Invalid offer ID.") long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Offer not found"));
    }

    @Override
    public T save(T offer) {
        return this.repository.save(offer);
    }

    @Override
    public void delete(T offer) {
        this.repository.delete(offer);
    }

    @Override
    public void update(T offer, Date date, String description, OfferStatus offerStatus) {
        if(offerStatus != null){
            offer.setOfferStatus(offerStatus);
        }
        OfferUpdate offerUpdate = new OfferUpdate(date, description, offerStatus);
        offer.updateUpdatesList(offerUpdate);
        this.repository.save(offer);
    }

}
