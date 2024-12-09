package net.springbootpractice.ems.repository;

import jakarta.transaction.Transactional;
import net.springbootpractice.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {

}
