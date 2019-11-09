package com.gzj.springdata.dao;

import com.gzj.springdata.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.From;
import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

    Employee findByEidAndEname(Integer eid,String ename);

    Employee getEmployeeByEid(Integer eid);

    /*@Query("from Employee")
    public List<Employee> ssssssssss();*/

}
