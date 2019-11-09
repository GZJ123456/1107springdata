package com.gzj.springdata.service;


import com.gzj.springdata.bean.Dept;
import com.gzj.springdata.bean.Employee;
import com.gzj.springdata.dao.DeptDao;
import com.gzj.springdata.dao.EmployeeDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

    @Resource
    private EmployeeDao employeeDao;


    @Resource
    private DeptDao deptDao;

    // 登录
    @Override
    public Employee login(Employee employee) {

        Employee emp = employeeDao.findByEidAndEname(employee.getEid(),employee.getEname());
        return emp;
    }


    // 显示所有用户
    @Override
    public Page<Employee> showInfo(Integer currentPage) {

        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"eid");
        Sort sort = Sort.by(order);

        /*分页工具   当前页传入  每页条数 */
        PageRequest pageRequest = PageRequest.of(currentPage,3,sort);
        Page<Employee> pageable = employeeDao.findAll(pageRequest);

        /*employeeDao.findAll()*/;
        return pageable;
    }

    @Override
    public boolean del(Integer eid) {
        employeeDao.deleteById(eid);
        return true;
    }


    @Override
    public Employee updateInfo(Integer eid) {

        Employee employee = employeeDao.getEmployeeByEid(eid);

        Integer deptno = employee.getDept().getDeptno();
        Dept dept = deptDao.findByDeptno(deptno);
        employee.setDept(dept);


        return employee;
    }


    @Override
    public boolean update(Employee employee) {
        employeeDao.save(employee);
        return true;
    }
}
