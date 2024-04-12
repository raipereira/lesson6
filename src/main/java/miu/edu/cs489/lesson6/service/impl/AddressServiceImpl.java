package miu.edu.cs489.lesson6.service.impl;

import miu.edu.cs489.lesson6.model.Address;
import miu.edu.cs489.lesson6.repository.AddressRepository;
import miu.edu.cs489.lesson6.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository repo;

    public AddressServiceImpl(AddressRepository repo) {
        this.repo = repo;
    }

    @Override
    public Address register(Address address) {
        return repo.save(address);
    }

    @Override
    public void registerAll(List<Address> addresses) {
        repo.saveAll(addresses);
    }


    @Override
    public List<Address> findAll() {
        return repo.findAll();
    }
}
