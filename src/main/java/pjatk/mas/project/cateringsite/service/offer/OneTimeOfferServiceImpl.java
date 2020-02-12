package pjatk.mas.project.cateringsite.service.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pjatk.mas.project.cateringsite.model.offer.OneTimeOffer;
import pjatk.mas.project.cateringsite.repository.offer.OfferRepository;

@Service
@Transactional
public class OneTimeOfferServiceImpl extends GenericOfferServiceImpl<OneTimeOffer> implements OneTimeOfferService {

    @Autowired
    public OneTimeOfferServiceImpl(OfferRepository<OneTimeOffer> repository) {
        super(repository);
    }
}
