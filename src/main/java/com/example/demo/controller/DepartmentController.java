package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/depts")
public class DepartmentController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department addDept(@RequestBody Department department){
        return departmentService.addDept(department);
    }

    @DeleteMapping("/{id}")
    public void delDept(@PathVariable int id){
        departmentService.delDept((long)id);
    }
}
