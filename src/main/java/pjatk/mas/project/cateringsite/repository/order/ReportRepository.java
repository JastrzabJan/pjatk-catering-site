package pjatk.mas.project.cateringsite.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pjatk.mas.project.cateringsite.model.order.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
