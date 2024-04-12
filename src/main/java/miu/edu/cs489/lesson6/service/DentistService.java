package miu.edu.cs489.lesson6.service;

import miu.edu.cs489.lesson6.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DentistService {

    Dentist registerOne(Dentist dentist);

    void registerAll(List<Dentist> dentists);
}
