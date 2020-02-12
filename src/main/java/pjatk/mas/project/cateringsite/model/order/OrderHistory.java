package pjatk.mas.project.cateringsite.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistory {

    @Basic
    @Getter
    @Setter
    @NotBlank(message = "Change description cannot be blank")
    private String changeDesc;

    @Setter
    @Getter
    @NotNull(message = "Change date cannot be null")
    private LocalDate changeDate;

}

