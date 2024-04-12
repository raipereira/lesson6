package miu.edu.cs489.lesson6.repository;

import miu.edu.cs489.lesson6.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
