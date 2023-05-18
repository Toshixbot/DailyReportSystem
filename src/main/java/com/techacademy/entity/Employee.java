package com.techacademy.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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


    /** 権限用の列挙型 */
    public static enum Role {
        一般, 管理者
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(name = "role", length = 10)
    @Enumerated(EnumType.STRING) // Role列挙型
    private Employee.Role role;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;


    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Authentication authentication;

    public String getCode() {
        return authentication != null ? authentication.getCode() : null;
    }

    public String getPassword() {
        return authentication != null ? authentication.getPassword() : null;
    }

}





