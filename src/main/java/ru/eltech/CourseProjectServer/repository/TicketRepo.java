package ru.eltech.CourseProjectServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eltech.CourseProjectServer.entity.TicketEntity;

@Repository
public interface TicketRepo extends JpaRepository<TicketEntity, Integer> {

}
