package pjatk.mas.project.cateringsite.service.order;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pjatk.mas.project.cateringsite.exception.ResourceNotFoundException;
import pjatk.mas.project.cateringsite.model.order.Report;
import pjatk.mas.project.cateringsite.repository.order.ReportRepository;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    private ReportRepository repository;

    public ReportServiceImpl(ReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public @NotNull Iterable<Report> getAllReports() {
        return this.repository.findAll();
    }

    @Override
    public Report getReport(@Min(value = 1L, message = "Invalid offer ID.") long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found"));
    }

    @Override
    public Report save(@Valid Report report) {
        return this.repository.save(report);
    }

    @Override
    public void delete(@Valid Report report) {
        this.repository.delete(report);

    }
}
