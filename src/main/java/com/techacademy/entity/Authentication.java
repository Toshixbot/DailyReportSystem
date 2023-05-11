package com.techacademy.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="authentication")
public class Authentication {

    @Id
    @Column(name = "code", length = 20)
    private String code;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "role", length = 10)
    private String role;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
