package miu.edu.cs489.lesson6.service.impl;

import miu.edu.cs489.lesson6.model.Dentist;
import miu.edu.cs489.lesson6.repository.DentistRepository;
import miu.edu.cs489.lesson6.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {

    private DentistRepository repo;

    public DentistServiceImpl(DentistRepository repo) {
        this.repo = repo;
    }

    @Override
    public Dentist registerOne(Dentist dentist) {
        return repo.save(dentist);
    }

    @Override
    public void registerAll(List<Dentist> dentists) {
        repo.saveAll(dentists);
    }
}
