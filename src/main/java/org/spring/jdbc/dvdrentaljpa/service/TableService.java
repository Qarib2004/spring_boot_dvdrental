package org.spring.jdbc.dvdrentaljpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getAllTables() {
        String query = "SELECT table_name FROM information_schema.tables WHERE table_schema='public'";
        return jdbcTemplate.queryForList(query, String.class);
    }
}
