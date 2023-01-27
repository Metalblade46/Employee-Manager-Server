package org.fullstack.Entity;

import org.fullstack.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
