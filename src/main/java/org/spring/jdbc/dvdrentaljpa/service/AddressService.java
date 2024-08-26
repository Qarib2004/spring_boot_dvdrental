package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.Address;
import org.spring.jdbc.dvdrentaljpa.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AddressService {

    private static final Logger logger = Logger.getLogger(AddressService.class.getName());

    @Autowired
    private AddressRepository addressRepository;

    public void insert(Address address) {
        logger.info("Insert address: " + address);
        addressRepository.save(address);
    }

    public void update(Address address) {
        logger.info("Update address: " + address);
        addressRepository.save(address);
    }

    public void delete(int addressId) {
        logger.info("Delete address by id: " + addressId);
        addressRepository.deleteById(addressId);
    }

    public List<Address> getAllAddresses() {
        logger.info("Select all addresses");
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(int addressId) {
        logger.info("Select address by id: " + addressId);
        return addressRepository.findById(addressId);
    }
}

