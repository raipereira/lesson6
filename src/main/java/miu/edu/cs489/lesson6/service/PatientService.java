package miu.edu.cs489.lesson6.service;

import miu.edu.cs489.lesson6.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientService {

    void registerAll(List<Patient> patients);

    Patient registerOne(Patient patient);
}
