package com.arpit.dao;

import com.arpit.model.Alien;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AlienDao {

    private JdbcTemplate jdbcTemplate;

    public void save(Alien alien){

        //added
    }

    public List<Alien> findAll(){

        return new ArrayList<Alien>();
    }
}
