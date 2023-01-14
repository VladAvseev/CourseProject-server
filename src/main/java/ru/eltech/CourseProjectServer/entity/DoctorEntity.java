package ru.eltech.CourseProjectServer.entity;

import jakarta.persistence.*;
import ru.eltech.CourseProjectServer.model.Ticket;

import java.util.List;

@Entity(name="doctor")
@Table(name="doctor")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private int id;
    @Column(name="name", length=50)
    private String name;
    @Column(name="license", length=9, unique=true)
    private String license;

    @Column(name="is_archived")
    private boolean is_archived;

//    @OneToMany(mappedBy = "doctor")
//    private List<TicketEntity> tickets;

    public DoctorEntity(int id, String name, String license) {
        this.id = id;
        this.name = name;
        this.license = license;
    }

    public DoctorEntity() {}

    public int getId() { return id; }

    public String getName() { return name; }

    public String getLicense() { return license; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setLicense(String license) { this.license = license; }

    public boolean isIs_archived() { return is_archived; }

    public void setIs_archived(boolean is_archived) { this.is_archived = is_archived; }

//    public List<TicketEntity> getTickets() { return tickets; }
//
//    public void setTickets(List<TicketEntity> tickets) { this.tickets = tickets; }
}
