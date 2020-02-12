package pjatk.mas.project.cateringsite.model.offer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class Diet extends Offer {

    @Basic
    @Getter
    @Setter
    @NotNull(message = "Month period cannot  be null")
    private BigDecimal monthPeriod;

    @Getter
    @Setter
    @Basic
    @NotNull(message = "Month price cannot be null")
    private BigDecimal monthPrice;

    public Diet(@NotNull(message = "Offer status cannot be null") OfferStatus offerStatus, @NotBlank(message = "Offer name cannot be blank") String name, @NotBlank(message = "Description name cannot be blank") String description, BigDecimal monthPeriod, BigDecimal monthPrice) {
        super(offerStatus, name, description);
        this.monthPeriod = monthPeriod;
        this.monthPrice = monthPrice;
    }

    @Override
    @Transient
    public BigDecimal getPrice() {
        return this.monthPrice.multiply(this.monthPeriod);
    }
}
