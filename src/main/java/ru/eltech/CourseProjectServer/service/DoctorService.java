package ru.eltech.CourseProjectServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eltech.CourseProjectServer.entity.DoctorEntity;
import ru.eltech.CourseProjectServer.repository.DoctorRepo;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    public List<DoctorEntity> getAllDoctors() throws SQLException {
        List<DoctorEntity> allDoctors = doctorRepo.findAll();
        return allDoctors.stream().filter(doctor -> !doctor.isIs_archived()).collect(Collectors.toList());
    }

    public Optional<DoctorEntity> getDoctorById(int id) throws SQLException {
        return doctorRepo.findById(id);
    }

    public DoctorEntity createDoctor(String name, String license) throws SQLException {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setName(name);
        doctorEntity.setLicense(license);
        return doctorRepo.save(doctorEntity);
    }

    public void updateDoctor(int id, String name, String license) throws SQLException {
        doctorRepo.update(name, license, id);
    }

    public void deleteDoctor(int id) throws SQLException {
        doctorRepo.delete(id);
    }
}
