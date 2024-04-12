package miu.edu.cs489.lesson6.service.impl;

import miu.edu.cs489.lesson6.model.Appointment;
import miu.edu.cs489.lesson6.repository.AppointmentRepository;
import miu.edu.cs489.lesson6.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository repo;

    public AppointmentServiceImpl(AppointmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public void registerAll(List<Appointment> appointments) {
        repo.saveAll(appointments);
    }

    @Override
    public List<Appointment> getAll() {
        return repo.findAll();
    }

}
