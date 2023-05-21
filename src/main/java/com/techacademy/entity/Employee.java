package com.techacademy.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")
@Where(clause = "delete_flag = 0")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;


    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Authentication authentication;



    public String getCode() {
        return authentication != null ? authentication.getCode() : null;
    }

    public String getPassword() {
        return authentication != null ? authentication.getPassword() : null;
    }


    }







