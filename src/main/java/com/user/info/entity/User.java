package com.user.info.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Master")
public class User {

    @Id
    @Column
    private String employeeNumber;
    @Column
    private String userName;
    @Column
    private String department;
    @Column
    private char userLevel;

}
