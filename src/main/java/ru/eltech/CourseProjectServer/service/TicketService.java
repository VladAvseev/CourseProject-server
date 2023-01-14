package ru.eltech.CourseProjectServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eltech.CourseProjectServer.entity.TicketEntity;
import ru.eltech.CourseProjectServer.model.Ticket;
import ru.eltech.CourseProjectServer.repository.TicketRepo;

import java.sql.SQLException;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepo ticketRepo;


    public List<Ticket> getAllTickets() throws SQLException {
        return ticketRepo.getAllTickets();
    }

//    public Ticket getTicketById(int id) throws SQLException {
//        return ticketRepo.getTicketById(id);
//    }

//    public TicketEntity createTicket(int doctorId, int patientId, String diagnosis) throws SQLException {
//        TicketEntity ticketEntity = new TicketEntity();
//        ticketEntity.setDoctorId(doctorId);
//        ticketEntity.setPatientId(patientId);
//        ticketEntity.setDiagnosis(diagnosis);
//        TicketEntity ticket = ticketRepo.save(ticketEntity);
//        return getTicketById(ticket.getId());
//    }
}
