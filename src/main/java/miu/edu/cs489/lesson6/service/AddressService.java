package miu.edu.cs489.lesson6.service;

import miu.edu.cs489.lesson6.model.Address;

import java.util.List;

public interface AddressService {

    Address register(Address address);
     void registerAll(List<Address> addresses);
    List<Address> findAll();


}
