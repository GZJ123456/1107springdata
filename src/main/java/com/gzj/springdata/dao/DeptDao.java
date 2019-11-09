package com.gzj.springdata.dao;

import com.gzj.springdata.bean.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeptDao extends JpaRepository<Dept,Integer> {

    Dept findByDeptno(Integer deptno);

    List<Dept> findByDeptnoNotIn(Integer deptno);
}
