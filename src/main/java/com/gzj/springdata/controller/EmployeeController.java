package com.gzj.springdata.controller;

import com.gzj.springdata.bean.Dept;
import com.gzj.springdata.bean.Employee;
import com.gzj.springdata.dao.EmployeeDao;
import com.gzj.springdata.service.DeptService;
import com.gzj.springdata.service.EmployeeService;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @Resource
    private DeptService deptService;


    //登录失败后跳转
    @RequestMapping( value = {"/","/index.html"})
    public String jump(){
        System.out.println("执行了跳转方法");
        return "login";
    }

    //登录
    @RequestMapping("login")
    public String login(Employee employee, ModelMap modelMap){

        Employee emp = employeeService.login(employee);
        if(emp != null){
            return "redirect:/showInfo";
        }else{
            modelMap.addAttribute("msg","登录失败");
            return "login";
        }
    }


    @RequestMapping("showInfo")
    public String showInfo(Model model,@RequestParam(name = "cp",defaultValue = "0") Integer currentPage){
        Page<Employee> list = employeeService.showInfo(currentPage);

        // 分页参数 和 每页的条数
        model.addAttribute("pageInfo",list);
        model.addAttribute("list",list.getContent());


        return "emp/main";
    }


    @RequestMapping("updateInfo")
    public String updateInfo(Integer eid,Model model){
        Employee employee = employeeService.updateInfo(eid);
        List<Dept> allDept = deptService.getAllDept(employee.getDept().getDeptno());
        System.out.println(allDept+"=========================");
        model.addAttribute("depts",allDept);
        model.addAttribute("emp",employee);
        return "emp/edit";
    }


    public Date getStringDateShort(String s) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date date =  formatter.parse(s);
        return date;
    }

    @RequestMapping("update")
    public String update(String dd, Employee employee) throws Exception {

        Date date = getStringDateShort(dd);
        /*employee.setHirdate();*/
        // 今天天气很好所有修改点内容  并且哥很帅....
        System.out.println(dd+"-------------"+"--------------------------------------");
        employee.setHirdate(date);

        boolean flag = employeeService.update(employee);
        return  "redirect:/showInfo";
    }



    @RequestMapping("del")
    public String del(Integer eid){
       employeeService.del(eid);

        return "redirect:/showInfo";
    }










}
