package ru.eltech.CourseProjectServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.eltech.CourseProjectServer.entity.DoctorEntity;
import ru.eltech.CourseProjectServer.service.DoctorService;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity getAllDoctors() {
        try {
            List<DoctorEntity> doctors = doctorService.getAllDoctors();
            return ResponseEntity.ok(doctors);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getDoctorById(@PathVariable int id) {
        try {
            Optional<DoctorEntity> doctor = doctorService.getDoctorById(id);
            return ResponseEntity.ok(doctor);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createDoctor(@RequestParam String name, @RequestParam String license) {
        try {
            DoctorEntity doctors = doctorService.createDoctor(name, license);
            return ResponseEntity.ok(doctors);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity updateDoctor(@PathVariable int id, @RequestParam String name, @RequestParam String license) {
        try {
            doctorService.updateDoctor(id, name, license);
            Optional<DoctorEntity> doctor = doctorService.getDoctorById(id);
            return ResponseEntity.ok(doctor);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteDoctor(@PathVariable int id) {
        try {
            doctorService.deleteDoctor(id);
            return ResponseEntity.ok("success");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
