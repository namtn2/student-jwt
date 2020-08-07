package com.example.namtn.demo.dao;

import com.example.namtn.demo.dto.ResultDTO;
import com.example.namtn.demo.model.Student;
import com.example.namtn.demo.utils.Constants;
import com.example.namtn.demo.utils.StringUtils;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Log4j
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public ResultDTO createOrUpdateStudent(Student student) {
        ResultDTO resultDTO = new ResultDTO();
        Student studentCreate = entityManager.merge(student);
        if (studentCreate != null && !StringUtils.isLongNullOrZero(studentCreate.getId())) {
            if (StringUtils.isLongNullOrZero(student.getId())) {
                resultDTO.setId(studentCreate.getId().toString());
            }
            resultDTO.setKey(Constants.RESULT.SUCCESS);
            resultDTO.setMessage(Constants.RESULT.SUCCESS);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO findAllStudent() {
        ResultDTO resultDTO = new ResultDTO();
        try {
            resultDTO.setMessage(Constants.RESULT.SUCCESS);
            resultDTO.setKey(Constants.RESULT.SUCCESS);
            List<Student> lst = entityManager.createQuery("select t from " + Student.class.getSimpleName() + " t").getResultList();
            if (lst != null && !lst.isEmpty()) {
                resultDTO.setLst(lst);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            resultDTO.setMessage(e.getCause().getMessage());
            resultDTO.setKey(Constants.RESULT.ERROR);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO findStudentById(Long id) {
        ResultDTO resultDTO = new ResultDTO();
        try {
            resultDTO.setMessage(Constants.RESULT.SUCCESS);
            resultDTO.setKey(Constants.RESULT.SUCCESS);
            Student s = entityManager.find(Student.class, id);
            if (s != null) {
                resultDTO.setObject(s);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            resultDTO.setMessage(e.getCause().getMessage());
            resultDTO.setKey(Constants.RESULT.ERROR);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO deleteStudent(Long id) {
        ResultDTO resultDTO = new ResultDTO();
        try {
            resultDTO.setMessage(Constants.RESULT.SUCCESS);
            resultDTO.setKey(Constants.RESULT.SUCCESS);
            Student s = entityManager.find(Student.class, id);
            if (s != null) {
                entityManager.remove(s);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            resultDTO.setMessage(e.getCause().getMessage());
            resultDTO.setKey(Constants.RESULT.ERROR);
        }
        return resultDTO;
    }
}
