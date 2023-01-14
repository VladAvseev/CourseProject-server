package ru.eltech.CourseProjectServer.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="patient")
@Table(name="patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patient_id")
    private int id;
    @Column(name="name", length=50)
    private String name;
    @Column(name="phone", length=11, unique=true)
    private String phone;

    @Column(name="is_archived")
    private boolean is_archived;

//    @OneToMany(mappedBy="patient")
//    private List<TicketEntity> tickets;

    public PatientEntity(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public PatientEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIs_archived() { return is_archived; }

    public void setIs_archived(boolean is_archived) { this.is_archived = is_archived; }

//    public List<TicketEntity> getTickets() { return tickets; }
//
//    public void setTickets(List<TicketEntity> tickets) { this.tickets = tickets; }
}
