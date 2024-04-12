package miu.edu.cs489.lesson6.repository;

import miu.edu.cs489.lesson6.model.Address;
import miu.edu.cs489.lesson6.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
