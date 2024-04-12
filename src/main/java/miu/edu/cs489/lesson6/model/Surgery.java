package miu.edu.cs489.lesson6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surgeryNumber;
    private String phoneNumber;
    @OneToOne
   // @Column(name = "location_id")
    private Address address;
    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;
}
