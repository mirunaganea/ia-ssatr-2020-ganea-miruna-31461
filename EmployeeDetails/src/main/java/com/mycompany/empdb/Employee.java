/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.empdb;

/**
 *
 * @author stanc
 */
public class Employee {
    private final String name;
    private final String gender;
    private String age;
    private String bloodgroup;
    private String contactno;
    private String qualification;
    private java.util.Date date;
    private String address;
    private byte[] image;
    private int id;

    public Employee(String name, String gender, String age, String bloodgroup, String contactno, String qualification, java.util.Date date, String address, byte[] image) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.bloodgroup = bloodgroup;
        this.contactno = contactno;
        this.qualification = qualification;
        this.date = date;
        this.address = address;
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getAge() {
        return age;
    }
    public String getBloodGroup() {
        return bloodgroup;
    }
    public String getContactNo() {
        return contactno;
    }
    public String getQualification() {
        return qualification;
    }
    public java.util.Date getDateJoined() {
        return date;
    }
    public String getAddress() {
        return address;
    
    }
    public byte[] getImage() {
        return image;
    }
    
}
