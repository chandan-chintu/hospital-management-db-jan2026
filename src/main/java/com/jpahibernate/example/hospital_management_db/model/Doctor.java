package com.jpahibernate.example.hospital_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // it represents that this class is entity or model class which is directly creating the database table or schema
@Table(name = "doctor") // it will create a table inside database
//@Data //  it will add getters and setters
@AllArgsConstructor // parameterized constructor
@NoArgsConstructor // default constructor
public class Doctor {

    @Id // it is the primary key of the table - it will be unique and it is not null
    @Column(name="id")  // it will create a column inside database table
    private int id;

    @Column(name="doctor_name", nullable = false) //nullable = false - it cannot contain null value
    private String name;

    @Column(name="email", nullable = false, unique = true) // unique=true - it cannot contain duplicated value
    private String email;

    @Column(name="specialization", nullable = false)
    private String specialization;

    @Column(name="dob", nullable = false)
    private String dob;

    @Column(name="mobile", nullable = false, unique = true)
    private String mobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
