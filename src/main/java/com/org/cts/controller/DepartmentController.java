package com.org.cts.controller;

import com.org.cts.model.Department;
import com.org.cts.model.Student;
import com.org.cts.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

      @Autowired
    DepartmentService departmentService;

    @PostMapping("/create")
    public void createStudent(@RequestBody Department department){
        departmentService.createStudent(department);

    }
    @PutMapping("/update")
    public void updateStudent(@RequestBody Department department){
        departmentService.updateStudent(department);
    }
    @GetMapping("/getAll")
    public List<Department> getAll() {
        List<Department> ll=  departmentService.getAll();
        return ll;
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Integer id){
      String ss=  departmentService.deleteById(id);
         return ss;
    }
    @GetMapping("/getById/{id}")
    public Department getById(@PathVariable Integer id){
        Department df=  departmentService.getById(id);
        return df;
    }
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        List<Student> ll=  departmentService.getAllStudents();
        return ll;
    }
}
