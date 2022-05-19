package com.org.cts.service;

import com.org.cts.model.Department;
import com.org.cts.model.Student;

import java.util.List;

public interface DepartmentService {
    public void createStudent( Department department);
    public void updateStudent( Department department);
    public List<Department> getAll();
    public String deleteById(Integer id);
    public Department getById( Integer id);
    public List<Student> getAllStudents();
}
