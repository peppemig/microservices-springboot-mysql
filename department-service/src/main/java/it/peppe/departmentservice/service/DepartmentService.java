package it.peppe.departmentservice.service;

import it.peppe.departmentservice.entity.Department;
import it.peppe.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> findDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<List<Department>> findDepartmentByDepartmentName(String departmentName){
        return departmentRepository.findByDepartmentName(departmentName);
    }

    public Optional<List<Department>> findDepartmentByDepartmentAddress(String departmentAddress){
        return departmentRepository.findByDepartmentAddress(departmentAddress);
    }

    public Optional<List<Department>> findDepartmentByDepartmentCode(String departmentCode){
        return departmentRepository.findByDepartmentCode(departmentCode);
    }
}
