package miu.edu.cs489.lesson6.service.impl;

import miu.edu.cs489.lesson6.model.Surgery;
import miu.edu.cs489.lesson6.repository.SurgeryRepository;
import miu.edu.cs489.lesson6.service.SurgeryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {

    private SurgeryRepository repo;

    public SurgeryServiceImpl(SurgeryRepository repo) {
        this.repo = repo;
    }

    @Override
    public void registerAll(List<Surgery> surgeries) {
        repo.saveAll(surgeries);
    }

    @Override
    public Surgery registerOne(Surgery surgery) {
        return repo.save(surgery);
    }
}
