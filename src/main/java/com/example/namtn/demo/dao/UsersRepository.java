package com.example.namtn.demo.dao;

import com.example.namtn.demo.dto.ResultDTO;
import com.example.namtn.demo.model.Student;
import com.example.namtn.demo.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository {

    ResultDTO findUserByUserName(String username);

//    ResultDTO create(Users user);
}
