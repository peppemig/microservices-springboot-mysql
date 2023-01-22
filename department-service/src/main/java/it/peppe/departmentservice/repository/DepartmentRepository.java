package it.peppe.departmentservice.repository;

import it.peppe.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Optional<List<Department>> findByDepartmentName(String departmentName);

    Optional<List<Department>> findByDepartmentAddress(String departmentAddress);

    Optional<List<Department>> findByDepartmentCode(String departmentCode);
}
