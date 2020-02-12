package pjatk.mas.project.cateringsite.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
public class Report {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    @Setter
    @Getter
    @NotNull(message = "Report start date cannot be null")
    private LocalDate startDate;

    @Setter
    @Getter
    @NotNull(message = "Report end date cannot be null")
    private LocalDate endDate;

    @Transient
    public Period getPeriod(){
        return Period.between(startDate, endDate);
    }

    @NotNull(message = "Orders list cannot be empty")
    @ManyToMany(mappedBy = "reports")
    private Set<Order> orders = new HashSet<>();

    public Report(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
