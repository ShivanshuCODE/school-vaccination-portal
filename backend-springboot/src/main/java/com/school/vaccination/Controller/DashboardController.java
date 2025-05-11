package com.school.vaccination.Controller;

import com.school.vaccination.Model.VaccineDrive;
import com.school.vaccination.Repository.StudentRepository;
import com.school.vaccination.Repository.VaccineDriveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final StudentRepository studentRepo;
    private final VaccineDriveRepository driveRepo;

    @GetMapping("/summary")
    public Map<String, Object> summary() {
        long total = studentRepo.count();
        long vaccinated = studentRepo.countByVaccinatedTrue();
        List<VaccineDrive> upcoming = driveRepo.findByDateBefore(LocalDate.now().plusDays(30));
        return Map.of(
                "totalStudents", total,
                "vaccinated", vaccinated,
                "percentageVaccinated", (double)vaccinated / total * 100,
                "upcomingDrives", upcoming
        );
    }
}
