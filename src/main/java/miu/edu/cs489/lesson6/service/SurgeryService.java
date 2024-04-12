package miu.edu.cs489.lesson6.service;

import miu.edu.cs489.lesson6.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurgeryService {

    void registerAll(List<Surgery> surgeries);

    Surgery registerOne(Surgery surgery);
}
