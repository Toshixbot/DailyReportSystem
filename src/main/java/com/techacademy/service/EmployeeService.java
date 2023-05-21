package com.techacademy.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techacademy.entity.Employee;
import com.techacademy.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }
    //* 全件を検索して返す */
    public List<Employee> getEmployeeList() {
        // リポジトリのfindAllメソッドを呼び出す
        return employeeRepository.findAll();
    }
    //件数取得
    public int getEmployeeCount() {
        return employeeRepository.findAll().size();
    }
    //** Userを１件検索して返す */
    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }



    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }



    }





