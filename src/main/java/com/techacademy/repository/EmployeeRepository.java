package com.techacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techacademy.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public void deleteByIdAndDeleteFlag(Integer id, Integer deleteFlag);

    public List<Employee> findAllByDeleteFlagOrderByCreatedAtAsc(Integer deleteFlag);
}