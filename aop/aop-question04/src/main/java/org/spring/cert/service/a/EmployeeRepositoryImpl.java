package org.spring.cert.service.a;

import org.spring.cert.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public /*final*/ class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public Employee findEmployeeById(long id) {
        return new Employee();
    }

    @Override
    public void saveEmployee(Employee employee) {
    }

    @Override
    public /*final*/ void deleteEmployee(Employee employee) {
    }

    @Override
    public void findAndUpdateEmployeeById(long id, Employee employeeToMerge) {
        Employee employeeById = findEmployeeById(id);
        saveEmployee(employeeById);
    }

    public void deleteByEmail(String email) {

    }
}
