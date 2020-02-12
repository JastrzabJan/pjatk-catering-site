package pjatk.mas.project.cateringsite.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryForm {

    @Basic
    @Getter
    @Setter
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Basic
    @Getter
    @Setter
    @NotBlank(message = "Surame cannot be blank")
    private String surname;

    @Basic
    @Getter
    @Setter
    @NotBlank(message = "Comment cannot be blank")
    private String comment;

    @Embedded
    @Getter
    @Setter
    private Address address;

}

