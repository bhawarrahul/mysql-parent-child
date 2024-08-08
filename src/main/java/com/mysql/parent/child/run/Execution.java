package com.mysql.parent.child.run;

import com.mysql.parent.child.entity.Employee;
import com.mysql.parent.child.entity.EmployeeAddress;
import com.mysql.parent.child.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class Execution {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void run() {
//        insertData();
//        fetchParentData();
//        fetchParentChildData();
    }

    private void insertData() {
        List<Employee> employeeList = new ArrayList<>();
        Stream.of(1, 2, 3).forEach(integer -> {
            Employee employee = Employee.builder()
                    .name("Rahul " + integer)
                    .addressList(new ArrayList<>())
                    .build();
            Stream.of(1, 2).forEach(integer1 -> {
                employee.addChild(EmployeeAddress.builder()
                        .name(integer + " - Pune - " + integer1)
                        .build());
            });
            employeeList.add(employee);
        });
        employeeRepository.saveAll(employeeList);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    private void fetchParentData() {
        List<Employee> employeeList = employeeRepository.findAll();
        employeeList.stream().forEach(employee -> {
            System.out.println(employee.getId() + " : " + employee.getName());
        });
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Employee> fetchParentChildData() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }
}
