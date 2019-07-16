package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    private static final int TARGET = 0;
    List<Employee> employeeList = new ArrayList<>();

    public void initList(){
        employeeList.add(new Employee(0,"Xiaoming",20,"Male"));
        employeeList.add(new Employee(1,"Xiaohong",19,"Female"));
        employeeList.add(new Employee(2,"Xiaozhi",15,"Male"));
        employeeList.add(new Employee(3,"Xiaogang",16,"Male"));
        employeeList.add(new Employee(4,"Xiaomxia",15,"Female"));
    }

    @GetMapping("/employeeList")
    public List<Employee> getAllEmployees(){
        initList();
        return employeeList;
    }

    @PostMapping
    public List<Employee> addEmployee(@RequestBody Employee employee){
        initList();
        employeeList.add(employee);
        return employeeList;
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id){
        initList();
        return employeeList.get(id);
    }

    @DeleteMapping("/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id){
        initList();
        employeeList.remove(employeeList.get(id));
        return employeeList;
    }

    @PutMapping
    public List<Employee> updateEmployee(@RequestBody Employee employee){
        initList();
        employeeList.get(employee.getId()).setAge(employee.getAge());
        employeeList.get(employee.getId()).setName(employee.getName());
        employeeList.get(employee.getId()).setGender(employee.getGender());
        return employeeList;
    }
}
