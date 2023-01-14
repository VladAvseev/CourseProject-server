package ru.eltech.CourseProjectServer.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.eltech.CourseProjectServer.entity.DoctorEntity;

import java.util.List;

public interface DoctorRepo extends JpaRepository<DoctorEntity, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE doctor SET name = ?1, license = ?2 WHERE id = ?3")
    void update(String name, String license, int id);

    @Modifying
    @Transactional
    @Query("UPDATE doctor SET is_archived = true WHERE id = ?1")
    void delete(int id);
}
