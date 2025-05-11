package com.school.vaccination.Controller;

import com.school.vaccination.Model.VaccinationRecord;
import com.school.vaccination.Repository.VaccinationRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class VaccinationRecordController {
    private final VaccinationRecordRepository repo;

    @GetMapping
    public List<VaccinationRecord> all() {
        return repo.findAll();
    }

    @PostMapping
    public VaccinationRecord create(@RequestBody VaccinationRecord record) {
        // Ensure one vaccination per vaccine per student
        boolean exists = repo.existsByStudentIdAndDriveId(record.getStudent().getId(), record.getDrive().getId());
        if (exists) throw new ResponseStatusException(HttpStatus.CONFLICT, "Already vaccinated");
        return repo.save(record);
    }
}

