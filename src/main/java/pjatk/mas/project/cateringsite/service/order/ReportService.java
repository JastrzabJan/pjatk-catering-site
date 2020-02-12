package pjatk.mas.project.cateringsite.service.order;


import org.springframework.validation.annotation.Validated;
import pjatk.mas.project.cateringsite.model.order.Report;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ReportService {

    @NotNull Iterable<Report> getAllReports();

    Report getReport(@Min(value = 1L, message = "Invalid report ID.") long id);

    Report save(@Valid Report report);

    void delete(@Valid Report report);
}
