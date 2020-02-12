package pjatk.mas.project.cateringsite.model.offer;



import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@NoArgsConstructor
public class OneTimeOffer extends Offer {

    @Basic
    @Setter
    @NotNull(message = "Price cannot be null")
    private BigDecimal price;

    public OneTimeOffer(@NotNull(message = "Offer status cannot be null") OfferStatus offerStatus, @NotBlank(message = "Offer name cannot be blank") String name, @NotBlank(message = "Description name cannot be blank") String description, BigDecimal price) {
        super(offerStatus, name, description);
        this.price = price;
    }

    @Override
    @Transient
    public BigDecimal getPrice() {
        return this.price;
    }

}
