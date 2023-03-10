package ru.eltech.CourseProjectServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.eltech.CourseProjectServer.entity.PatientEntity;
import ru.eltech.CourseProjectServer.service.PatientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity getAllPatients() {
        try {
            List<PatientEntity> patients = patientService.getAllPatients();
            return ResponseEntity.ok(patients);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getPatientById(@PathVariable int id) {
        try {
            Optional<PatientEntity> patient = patientService.getPatientById(id);
            return ResponseEntity.ok(patient);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createPatient(@RequestParam String name, @RequestParam String phone, @RequestParam String email) {
        try {
            PatientEntity patient = patientService.createPatient(name, phone, email);
            return ResponseEntity.ok(patient);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity updatePatient(@PathVariable int id, @RequestParam String name, @RequestParam String phone, @RequestParam String email) {
        try {
            patientService.updatePatient(id, name, phone, email);
            Optional<PatientEntity> patient = patientService.getPatientById(id);
            return ResponseEntity.ok(patient);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteDoctor(@PathVariable int id) {
        try {
            patientService.deletePatient(id);
            return ResponseEntity.ok("success");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
