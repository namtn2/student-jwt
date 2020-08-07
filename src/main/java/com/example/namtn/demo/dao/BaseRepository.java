package com.example.namtn.demo.dao;

import com.example.namtn.demo.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository extends CrudRepository<Users, Long> {

}
