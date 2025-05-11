package com.school.vaccination.Controller;

import com.school.vaccination.Model.Student;
import com.school.vaccination.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository repo;

    @GetMapping
    public List<Student> getAll() { return repo.findAll(); }

    @PostMapping
    public Student create(@RequestBody Student s) { return repo.save(s); }

    @PostMapping("/bulk")
    public List<Student> bulkUpload(@RequestBody List<Student> students) {
        return repo.saveAll(students);
    }

    @PutMapping("/{id}/vaccinate")
    public Student markVaccinated(@PathVariable Long id) {
        Student s = repo.findById(id).orElseThrow();
        s.setVaccinated(true);
        return repo.save(s);
    }
}

