package com.bicovski.department.controller;

import com.bicovski.department.entity.Department;
import com.bicovski.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside saveDepartment Controller Method");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("Inside findDepartment Controller Method");
        return departmentService.findDepartmentById(departmentId);
    }
}
