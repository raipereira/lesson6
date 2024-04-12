package miu.edu.cs489.lesson6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime appointmentDate;
    @ManyToOne
    private Dentist dentist;
    @ManyToOne
    private Surgery surgery;
    @ManyToOne
    private Patient patient;




}

interface AppointmentProjection {
    String getDentistFullName();
    String getPatientNumber();
    String getPatientName();
    LocalDateTime getAppointmentDateTime();
    String getSurgeryNumber();
}
