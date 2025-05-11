package com.school.vaccination.Repository;

import com.school.vaccination.Model.Student;
import com.school.vaccination.Model.VaccinationRecord;
import com.school.vaccination.Model.VaccineDrive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    long countByVaccinatedTrue();
}


