package miu.edu.cs489.lesson6.repository;

import miu.edu.cs489.lesson6.model.Address;
import miu.edu.cs489.lesson6.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
