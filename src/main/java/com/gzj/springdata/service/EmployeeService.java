package com.gzj.springdata.service;

import com.gzj.springdata.bean.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee login(Employee employee);

    Page<Employee> showInfo(Integer currentPage);

    boolean del(Integer eid);


    Employee updateInfo(Integer eid);

    boolean update(Employee employee);
}
