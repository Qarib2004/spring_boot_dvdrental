package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.Store;
import org.spring.jdbc.dvdrentaljpa.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class StoreService {

    private static final Logger logger = Logger.getLogger(StoreService.class.getName());

    @Autowired
    private StoreRepository storeRepository;

    public void insert(Store store) {
        logger.info("Insert store: " + store);
        storeRepository.save(store);
    }

    public void update(Store storeId) {
        logger.info("Update store by id: " + storeId);
         storeRepository.save(storeId);
    }

    public void delete(int storeId) {
        logger.info("Delete store by id: " + storeId);
        storeRepository.deleteById(storeId);
    }

    public List<Store> getAllStores() {
        logger.info("Select all table: store");
        return storeRepository.findAll();
    }

    public Optional<Store> getStoreById(int storeId) {
        logger.info("Select store by id: " + storeId);
        return storeRepository.findById(storeId);
    }
}

