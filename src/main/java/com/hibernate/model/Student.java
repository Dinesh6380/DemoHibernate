package com.hibernate.model;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@NamedQueries({ @NamedQuery(name = "@HQL_GET_ALL_STUDENT", 
query = "from Student") })
@NamedNativeQueries({ @NamedNativeQuery(name = "@SQL_GET_ALL_STUDENT", 
query = "select id, Last_name,First_name from Student") })

@Table (name = "Student") 
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "id")
	private long id;
	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", Lname=" + Lname + ", email=" + email + "]";
	}
	@Column(name = "first_name")
	private String fname;
	@Column(name = "Last_name")
	private String Lname;
	@Column(name = "email")
	private String email;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Student( String fname, String lname, String email) {
		super();
		//this.id = id;
		this.fname = fname;
		Lname = lname;
		this.email = email;
	}
}
