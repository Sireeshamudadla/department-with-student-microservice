package com.org.cts.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.cts.model.Department;
import com.org.cts.model.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.org.cts.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentRepo departmentRepo;

    @Bean
    public RestTemplate restTemplate(){
       return new RestTemplate();
    }
    @Override
    public void createStudent(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public void updateStudent(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public List<Department> getAll() {
        List<Department> lis=departmentRepo.findAll();
        return lis;
    }

    @Override
    public String deleteById(Integer id) {
        departmentRepo.deleteById(id);
        return "success";
    }

    @Override
    public Department getById(Integer id) {
        Department dd= departmentRepo.getById(id);
        return dd;
    }

    @Override
    public List<Student> getAllStudents() {
        ObjectMapper mapper=new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String jsonBody = restTemplate().exchange("http://localhost:8989/api/getAll",HttpMethod.GET, entity, String.class).getBody();
       List<Student>list=null;
        try {
            list=mapper.readValue(jsonBody,new TypeReference<List<Student>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
