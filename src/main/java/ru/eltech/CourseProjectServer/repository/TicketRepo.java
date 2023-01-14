package ru.eltech.CourseProjectServer.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.eltech.CourseProjectServer.entity.TicketEntity;
import ru.eltech.CourseProjectServer.model.Ticket;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<TicketEntity, Integer> {

    @Transactional
    @Query(value = """
            SELECT ticket.id as id, doctor.name as doctor_name, patient.name as patient_name, ticket.diagnosis as diagnosis
            FROM DoctorEntity doctor
            INNER JOIN TicketEntity ticket ON doctor.doctor_id = ticket.doctor_id
            INNER JOIN PatientEntity patient ON ticket.patient_id = patient.patient_id""", nativeQuery = true)
    List<Ticket> getAllTickets();

//    @Transactional
//    @Modifying
//    @Query("""
//            SELECT ticket_id, doctor.name as doctor_name, patient.name as patient_name, diagnosis
//            FROM doctor
//            INNER JOIN ticket ON doctor.doctor_id = ticket.doctor_id
//            INNER JOIN patient ON ticket.patient_id = patient.patient_id
//            WHERE ticket_id = ?1""")
//    Ticket getTicketById(int id);
}
