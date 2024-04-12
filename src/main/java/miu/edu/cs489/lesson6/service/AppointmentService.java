package miu.edu.cs489.lesson6.service;

import miu.edu.cs489.lesson6.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentService {

    void registerAll(List<Appointment> appointments);

    List<Appointment> getAll();
}
