package pjatk.mas.project.cateringsite.service.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pjatk.mas.project.cateringsite.model.offer.Diet;
import pjatk.mas.project.cateringsite.repository.offer.OfferRepository;

@Service
@Transactional
public class DietServiceImpl extends GenericOfferServiceImpl<Diet> implements DietService  {

    @Autowired
    public DietServiceImpl(OfferRepository<Diet> repository) {
        super(repository);
    }
}
