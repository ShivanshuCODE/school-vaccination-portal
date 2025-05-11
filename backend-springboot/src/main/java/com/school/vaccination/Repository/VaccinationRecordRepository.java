package com.school.vaccination.Repository;

import com.school.vaccination.Model.VaccinationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRecordRepository extends JpaRepository<VaccinationRecord, Long> {
    boolean existsByStudentIdAndDriveId(Long id, Long id1);
}
