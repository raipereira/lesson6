package miu.edu.cs489.lesson6.service.impl;

import miu.edu.cs489.lesson6.model.Patient;
import miu.edu.cs489.lesson6.repository.PatientRepository;
import miu.edu.cs489.lesson6.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository repo;

    public PatientServiceImpl(PatientRepository repo) {
        this.repo = repo;
    }

    @Override
    public void registerAll(List<Patient> patients) {
        repo.saveAll(patients);
    }

    @Override
    public Patient registerOne(Patient patient) {
        return repo.save(patient);
    }
}
