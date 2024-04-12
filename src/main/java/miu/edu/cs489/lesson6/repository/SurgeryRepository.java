package miu.edu.cs489.lesson6.repository;

import miu.edu.cs489.lesson6.model.Address;
import miu.edu.cs489.lesson6.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {
}
