package pjatk.mas.project.cateringsite.model.offer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class OfferUpdate {


    @Setter
    @Getter
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Update date is required")
    private Date updateDate;

    @Basic
    @Getter
    @Setter
    @NotBlank(message = "Update description cannot be null")
    private String updateDesc;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;

}
