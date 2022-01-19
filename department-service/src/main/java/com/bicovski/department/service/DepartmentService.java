package com.bicovski.department.service;

import com.bicovski.department.entity.Department;
import com.bicovski.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment Service Method");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long id) {
        log.info("Inside getDepartment Service Method");
        return departmentRepository.findByDepartmentId(id);
    }
}
