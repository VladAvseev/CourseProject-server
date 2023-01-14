package ru.eltech.CourseProjectServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eltech.CourseProjectServer.entity.DoctorEntity;
import ru.eltech.CourseProjectServer.entity.PatientEntity;
import ru.eltech.CourseProjectServer.entity.TicketEntity;
import ru.eltech.CourseProjectServer.model.Ticket;
import ru.eltech.CourseProjectServer.repository.DoctorRepo;
import ru.eltech.CourseProjectServer.repository.PatientRepo;
import ru.eltech.CourseProjectServer.repository.TicketRepo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private PatientRepo patientRepo;


    public List<Ticket> getAllTickets() throws SQLException {
        List<TicketEntity> ticketEntities = ticketRepo.findAll();
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (TicketEntity ticketEntity: ticketEntities) {
            tickets.add(Ticket.toModel(ticketEntity));
        }
        return tickets;
    }

    public Ticket createTicket(int doctorId, int patientId, String diagnosis) throws SQLException {
        TicketEntity ticketEntity = new TicketEntity();

        Optional<DoctorEntity> doctorEntity = doctorRepo.findById(doctorId);
        doctorEntity.ifPresent(ticketEntity::setDoctor);

        Optional<PatientEntity> patientEntity = patientRepo.findById(patientId);
        patientEntity.ifPresent(ticketEntity::setPatient);

        ticketEntity.setDiagnosis(diagnosis);

        TicketEntity ticket = ticketRepo.save(ticketEntity);
        return Ticket.toModel(ticket);
    }

    public void deleteTicket(int id) {
        ticketRepo.deleteById(id);
    }
}
