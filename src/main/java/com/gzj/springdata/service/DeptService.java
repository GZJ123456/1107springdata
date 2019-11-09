package com.gzj.springdata.service;

import com.gzj.springdata.bean.Dept;

import java.util.List;

public interface DeptService {


    List<Dept> getAllDept(Integer deptno);
}
