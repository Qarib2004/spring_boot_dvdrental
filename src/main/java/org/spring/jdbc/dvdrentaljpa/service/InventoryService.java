package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.Inventory;
import org.spring.jdbc.dvdrentaljpa.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class InventoryService {
    private static final Logger logger = Logger.getLogger(InventoryService.class.getName());

    @Autowired
    private InventoryRepository inventoryRepository;

    public void insert(Inventory inventory) {
        logger.info("Insert inventory: " + inventory);
        inventoryRepository.save(inventory);
    }

    public void update(Inventory inventoryId) {
        logger.info("Update inventory by id: " + inventoryId);
        inventoryRepository.save(inventoryId);
    }

    public void delete(int inventoryId) {
        logger.info("Delete inventory by id: " + inventoryId);
        inventoryRepository.deleteById(inventoryId);
    }

    public List<Inventory> getAllInventories() {
        logger.info("Select all table: inventory");
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryById(int inventoryId) {
        logger.info("Select inventory by id: " + inventoryId);
        return inventoryRepository.findById(inventoryId);
    }
}
