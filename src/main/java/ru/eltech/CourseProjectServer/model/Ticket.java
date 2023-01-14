package ru.eltech.CourseProjectServer.model;

import ru.eltech.CourseProjectServer.entity.TicketEntity;

import java.util.List;

public class Ticket {
    private int id;
    private String doctorName;
    private String patientName;
    private String diagnosis;

    public Ticket(int id, String diagnosis, String doctorName, String patientName) {
        this.id = id;
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
    }

    public Ticket() {}

    public static Ticket toModel(TicketEntity ticketEntity) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketEntity.getId());
        ticket.setDoctorName(ticketEntity.getDoctor().getName());
        ticket.setPatientName(ticketEntity.getPatient().getName());
        ticket.setDiagnosis(ticketEntity.getDiagnosis());
        return ticket;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDiagnosis() { return diagnosis; }

    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public String getPatientName() { return patientName; }

    public void setPatientName(String patientName) { this.patientName = patientName; }
}
