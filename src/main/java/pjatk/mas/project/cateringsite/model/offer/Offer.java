package pjatk.mas.project.cateringsite.model.offer;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public abstract class Offer {

    @ElementCollection
    @Getter
    @Setter
    private Set<OfferUpdate> offerUpdates = new HashSet();

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    @NotNull(message = "Offer status cannot be null")
    private OfferStatus offerStatus;

    @Basic
    @Getter
    @Setter
    @NotBlank(message = "Offer name cannot be blank")
    private String name;

    @Getter
    @Setter
    @Basic
    @NotBlank(message = "Description name cannot be blank")
    private String description;

    public void updateUpdatesList(OfferUpdate offerUpdate){
        this.offerUpdates.add(offerUpdate);
    }

    public abstract BigDecimal getPrice();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offer product = (Offer) o;

        return offerId.equals(product.offerId);
    }

    @Override
    public int hashCode() {
        return offerId.hashCode();
    }

    public Offer(OfferStatus offerStatus, String name, String description) {
        this.offerStatus = offerStatus;
        this.name = name;
        this.description = description;
    }
}
