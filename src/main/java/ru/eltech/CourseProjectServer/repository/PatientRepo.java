package ru.eltech.CourseProjectServer.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.eltech.CourseProjectServer.entity.PatientEntity;

public interface PatientRepo extends JpaRepository<PatientEntity, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE patient SET name = ?1, phone = ?2, email = ?3 WHERE id = ?4")
    void update(String name, String phone, String email, int id);

    @Modifying
    @Transactional
    @Query("UPDATE patient SET is_archived = true WHERE id = ?1")
    void delete(int id);
}
