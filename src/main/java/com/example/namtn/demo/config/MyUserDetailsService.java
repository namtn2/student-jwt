package com.example.namtn.demo.config;

import com.example.namtn.demo.dao.UsersRepository;
import com.example.namtn.demo.dto.ResultDTO;
import com.example.namtn.demo.model.Users;
import com.example.namtn.demo.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ResultDTO resultDTO = usersRepository.findUserByUserName(s);
        if (Constants.RESULT.SUCCESS.equals(resultDTO.getKey()) && resultDTO.getObject() != null) {
            Users u = (Users) resultDTO.getObject();
            return new User(u.getUserName(), u.getPassword(), new ArrayList<>());
        }
        return null;
    }
}
