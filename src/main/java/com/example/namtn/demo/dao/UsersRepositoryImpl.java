package com.example.namtn.demo.dao;

import com.example.namtn.demo.dto.ResultDTO;
import com.example.namtn.demo.model.Users;
import com.example.namtn.demo.utils.Constants;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
@Log4j
public class UsersRepositoryImpl implements UsersRepository {
    @Autowired
    EntityManager entityManager;

    @Override
    public ResultDTO findUserByUserName(String username) {
        ResultDTO resultDTO = new ResultDTO();
        try {
            resultDTO.setMessage(Constants.RESULT.SUCCESS);
            resultDTO.setKey(Constants.RESULT.SUCCESS);
            Query query = entityManager.createNativeQuery("select * from USERS where user_name = :username ", Users.class);
            query.setParameter("username", username);
            Users u = (Users) query.getSingleResult();
            if (u != null) {
                resultDTO.setObject(u);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            resultDTO.setMessage(e.getCause().getMessage());
            resultDTO.setKey(Constants.RESULT.ERROR);
        }
        return resultDTO;
    }

//    @Override
//    public ResultDTO create(Users user) {
//        ResultDTO resultDTO = new ResultDTO();
//        Users u = entityManager.merge(user);
//        resultDTO.setId(u.getUserId().toString());
//        resultDTO.setKey(Constants.RESULT.SUCCESS);
//        resultDTO.setMessage(Constants.RESULT.SUCCESS);
//        return resultDTO;
//    }
}
