package edu.miu.lelafoods.delivery.service;

import edu.miu.lelafoods.delivery.domain.Address;

import java.util.List;

public interface AddressService {
    public void save(Address address);
    public List<Address> findAll();
    public void deleteById(Long id);
    public Address findById(Long id);
}
