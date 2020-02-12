package pjatk.mas.project.cateringsite.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Getter
    @Setter
    @Basic
    private String city;

    @Getter
    @Setter
    @Basic
    private String street;

    @Getter
    @Setter
    @Basic
    private String postalCode;

    @Getter
    @Setter
    @Basic
    private int homeNo;
}
