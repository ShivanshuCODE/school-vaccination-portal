package com.school.vaccination.Controller;

import com.school.vaccination.Model.VaccineDrive;
import com.school.vaccination.Repository.VaccineDriveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/drives")
@RequiredArgsConstructor
public class VaccineDriveController {
    private final VaccineDriveRepository driveRepo;

    @GetMapping("/upcoming")
    public List<VaccineDrive> upcoming() {
        return driveRepo.findByDateAfter(LocalDate.now());
    }

    @PostMapping
    public VaccineDrive create(@RequestBody VaccineDrive d) {
        if (d.getDate().isBefore(LocalDate.now().plusDays(15))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Drive must be scheduled 15+ days ahead");
        }
        return driveRepo.save(d);
    }

    @PutMapping("/{id}")
    public VaccineDrive edit(@PathVariable Long id, @RequestBody VaccineDrive input) {
        VaccineDrive d = driveRepo.findById(id).orElseThrow();
        if (d.getDate().isBefore(LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot edit past drives");
        }
        d.setDate(input.getDate());
        d.setDosesAvailable(input.getDosesAvailable());
        return driveRepo.save(d);
    }
}

