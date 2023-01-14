package ru.eltech.CourseProjectServer.model;

import ru.eltech.CourseProjectServer.entity.TicketEntity;

import java.util.List;

public class Ticket extends TicketEntity {
    private String doctorName;
    private String patientName;

    public Ticket(int id, String diagnosis, String doctorName, String patientName) {
        super(id, diagnosis);
        this.doctorName = doctorName;
        this.patientName = patientName;
    }

    public Ticket() {}

    public String getDoctorName() {
            return doctorName;
        }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public String getPatientName() {
            return patientName;
        }

    public void setPatientName(String patientName) {
            this.patientName = patientName;
        }
}
