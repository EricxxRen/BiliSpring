package com.rxx.coffeejourney.controller;

import com.rxx.coffeejourney.dao.DepartmentDao;
import com.rxx.coffeejourney.dao.EmployeeDao;
import com.rxx.coffeejourney.entity.Department;
import com.rxx.coffeejourney.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    //注入DAO
    //实际使用中应该是EmployeeService
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping(value = "/emps")
    //此处Model可以是Model，Map，ModelMap都可以
    public String list (Model model) {

        List<Employee> employees =  employeeDao.getAll();

        //放在请求域中进行共享
        model.addAttribute("emps", employees);

        //themeleaf会拼串
        //默认配置到org/springframework/boot/autoconfigure/thymeleaf/ThymeleafProperties.java中的DEFAULT_PREFIX后
        //即返回classpath:/templates/emp/list.html
        return "emp/list";
    }

    //员工添加页面跳转
    @GetMapping(value = "/emp")
    public String addPage (ModelMap modelMap) {
        List<Department> departments = departmentDao.getAll();
        modelMap.addAttribute("departments", departments);
        return "emp/add";
    }

    //员工添加功能
    @PostMapping(value = "emp")
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定
    //要求是请求参数的名字和JavaBean入参的属性名相同
    public String addEmp (Employee employee) {

        employeeDao.save(employee);

        //添加完成后回到列表页面,redirect(重定向到一个地址)或forward(转发到一个地址) /代表当前项目路径
        //return "forward:/emps" 或 return "redirect:/emps"
        return "redirect:/emps";
    }

    //员工修改页面跳转
    //来到修改页面，查出当前员工
    @GetMapping(value = "emp/{id}")
    public String editPage (@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.getEmployee(id);
        model.addAttribute("emp", employee);
        List<Department> departments = departmentDao.getAll();
        model.addAttribute("departments", departments);
        return "emp/edit";

    }

    //员工修改功能
    @PutMapping(value = "emp")
    public String editEmp (Employee employee) {
        employeeDao.update(employee);
        return "redirect:/emps";
    }

    //员工删除功能
    @DeleteMapping(value = "emp/{id}")
    public String deleteEmp (@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
