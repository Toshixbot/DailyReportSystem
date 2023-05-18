package com.techacademy.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="authentication")
public class Authentication {

    /** 認証情報の権限のRole列挙型 */
    public static enum Role {
        一般, 管理者
    }

    @Id
    @Column(name = "code", length = 20)
    private String code;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "role", length = 10)
    @Enumerated(EnumType.STRING) // Role列挙型を使用する
    private Employee.Role role;


    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
