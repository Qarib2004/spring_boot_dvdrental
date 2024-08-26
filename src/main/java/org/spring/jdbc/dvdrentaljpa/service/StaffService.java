package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.Staff;
import org.spring.jdbc.dvdrentaljpa.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class StaffService {

    private static final Logger logger = Logger.getLogger(StaffService.class.getName());

    @Autowired
    private StaffRepository staffRepository;

    public void insert(Staff staff) {
        logger.info("Insert staff: " + staff);
      staffRepository.save(staff);
    }

    public void update(Staff staffId) {
        logger.info("Update staff by id: " + staffId);
        staffRepository.save(staffId);
    }

    public void delete(int staffId) {
        logger.info("Delete staff by id: " + staffId);
        staffRepository.deleteById(staffId);
    }

    public List<Staff> getAllStaff() {
        logger.info("Select all table: staff");
        return staffRepository.findAll();
    }

    public Optional<Staff> getStaffById(int staffId) {
        logger.info("Select staff by id: " + staffId);
        return staffRepository.findById(staffId);
    }
}

