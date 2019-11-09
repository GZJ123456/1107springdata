package com.gzj.springdata.service;

import com.gzj.springdata.bean.Dept;
import com.gzj.springdata.dao.DeptDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {


    @Resource
    private DeptDao deptDao;

    @Override
    public List<Dept> getAllDept(Integer deptno) {
        return deptDao.findByDeptnoNotIn(deptno);
    }
}
