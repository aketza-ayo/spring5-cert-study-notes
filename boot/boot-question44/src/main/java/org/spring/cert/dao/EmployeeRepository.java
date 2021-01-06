package org.spring.cert.dao;

import org.spring.cert.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Employee findByEmail(String email);
}
