package ru.eltech.CourseProjectServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eltech.CourseProjectServer.entity.PatientEntity;
import ru.eltech.CourseProjectServer.repository.PatientRepo;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    public List<PatientEntity> getAllPatients() throws SQLException {
        List<PatientEntity> allPatients = patientRepo.findAll();
        return allPatients.stream().filter(patient -> !patient.isIs_archived()).collect(Collectors.toList());
    }

    public Optional<PatientEntity> getPatientById(int id) throws SQLException {
        return patientRepo.findById(id);
    }

    public PatientEntity createPatient(String name, String phone, String email) throws SQLException {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setName(name);
        patientEntity.setPhone(phone);
        patientEntity.setEmail(email);
        return patientRepo.save(patientEntity);
    }

    public void updatePatient(int id, String name, String phone, String email) throws SQLException {
        patientRepo.update(name, phone, email, id);
    }

    public void deletePatient(int id) throws SQLException {
        patientRepo.delete(id);
    }
}
