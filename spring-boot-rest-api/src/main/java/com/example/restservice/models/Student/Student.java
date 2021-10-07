package com.example.restservice.models.Student;


import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "Student")

public class Student{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "institutionid")
    private String institutionid;

    @Column(name = "studentid")
    private String studentid;

    @Column(name = "firstname")
    private String firstname;
    
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "dateofbirth")
    private Date dateofbirth;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "email")
    private String email;

    
	public Student() {
	    	
	    }


	public Student(String institutionid, String studentid, String firstname, String lastname, Date dateofbirth,
			String gender, String email) {
		super();
		this.institutionid = institutionid;
		this.studentid = studentid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.email = email;
	}


	public long getId() {
        return id;
    }


	public String getInstitutionid() {
		return institutionid;
	}


	public void setInstitutionid(String institutionid) {
		this.institutionid = institutionid;
	}


	public String getStudentid() {
		return studentid;
	}


	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Date getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Student [regid=" + id + ", institutionid=" + institutionid + ", studentid=" + studentid
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", dateofbirth=" + dateofbirth + ", gender="
				+ gender + ", email=" + email + "]";
	}

	
	
	
}