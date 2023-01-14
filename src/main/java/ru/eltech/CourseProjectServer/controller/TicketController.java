package ru.eltech.CourseProjectServer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.eltech.CourseProjectServer.entity.TicketEntity;
import ru.eltech.CourseProjectServer.model.Ticket;
import ru.eltech.CourseProjectServer.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity getAllTickets() {
        try {
            List<Ticket> tickets = ticketService.getAllTickets();
            return ResponseEntity.ok(tickets);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createTicket(@RequestParam int doctorId, @RequestParam int patientId, @RequestParam String diagnosis) {
        try {
            Ticket ticket = ticketService.createTicket(doctorId, patientId, diagnosis);
            return ResponseEntity.ok(ticket);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTicket(@PathVariable int id) {
        try {
            ticketService.deleteTicket(id);
            return ResponseEntity.ok("success");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
