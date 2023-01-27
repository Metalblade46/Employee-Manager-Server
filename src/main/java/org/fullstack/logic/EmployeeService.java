package org.fullstack.logic;

import org.fullstack.Entity.Employee;
import org.fullstack.Entity.EmployeeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class EmployeeService {
    @Inject
   private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(long id){
         employeeRepository.deleteById(id);
    }
    public Employee findEmployeebyId(long id){
        Optional<Employee> byId = employeeRepository.findById(id);
        if(byId.isPresent())
            return byId.get();
        else
            return null;
    }
}
