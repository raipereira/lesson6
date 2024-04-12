package miu.edu.cs489.lesson6.repository;

import miu.edu.cs489.lesson6.model.Address;
import miu.edu.cs489.lesson6.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
