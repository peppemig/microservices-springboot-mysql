package it.peppe.departmentservice.controller;

import it.peppe.departmentservice.entity.Department;
import it.peppe.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{departmentId}")
    public Optional<Department> getDepartmentById(@PathVariable Long departmentId){
        return departmentService.findDepartmentById(departmentId);
    }

    @GetMapping("/name/{departmentName}")
    public Optional<List<Department>> getDepartmentByDepartmentName(@PathVariable String departmentName){
        return departmentService.findDepartmentByDepartmentName(departmentName);
    }

    @GetMapping("/address/{departmentAddress}")
    public Optional<List<Department>> getDepartmentByDepartmentAddress(@PathVariable String departmentAddress){
        return departmentService.findDepartmentByDepartmentAddress(departmentAddress);
    }

    @GetMapping("/code/{departmentCode}")
    public Optional<List<Department>> getDepartmentByDepartmentCode(@PathVariable String departmentCode){
        return departmentService.findDepartmentByDepartmentCode(departmentCode);
    }
}
