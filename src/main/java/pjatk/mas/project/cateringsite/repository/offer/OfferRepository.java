package pjatk.mas.project.cateringsite.repository.offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pjatk.mas.project.cateringsite.model.offer.Offer;

@NoRepositoryBean
public interface OfferRepository<T extends Offer> extends JpaRepository<T , Long> {
}
