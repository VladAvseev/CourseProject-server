package ru.eltech.CourseProjectServer.entity;

import jakarta.persistence.*;

@Entity(name="ticket")
@Table(name="ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticket_id")
    private int id;

    @Column(name="diagnosis")
    private String diagnosis;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private PatientEntity patient;

    public TicketEntity(int id, String diagnosis) {
        this.id = id;
        this.diagnosis = diagnosis;
    }

    public TicketEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}