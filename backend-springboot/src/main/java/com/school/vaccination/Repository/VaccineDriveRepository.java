package com.school.vaccination.Repository;
import java.util.List;
import com.school.vaccination.Model.VaccineDrive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface VaccineDriveRepository extends JpaRepository<VaccineDrive, Long> {
    List<VaccineDrive> findByDateAfter(LocalDate now);

    List<VaccineDrive> findByDateBefore(LocalDate localDate);
}
