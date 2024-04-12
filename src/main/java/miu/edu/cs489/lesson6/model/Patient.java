package miu.edu.cs489.lesson6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String patientNumber;
    private String phoneNumber;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;


    public String getFullName(){
        return firstName + " " + lastName;
    }
}
