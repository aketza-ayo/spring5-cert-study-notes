package org.spring.cert.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceB {

    @Transactional
    public void operationB() {
    }
}
