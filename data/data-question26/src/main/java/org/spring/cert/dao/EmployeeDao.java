package org.spring.cert.dao;


import org.spring.cert.ds.Employee;
import org.spring.cert.ds.EmployeeKey;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, EmployeeKey> {
}
