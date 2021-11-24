package com.tanmay;

public class Student {
	private int id;
	private String name;
	private String city;
	private String email;
	private String sex;
	private int age;
	private int marks;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + ", sex=" + sex
				+ ", age=" + age + ", marks=" + marks + "]";
	}
	public Student(String name, String city, String email, String sex, int age, int marks) {
		super();
		this.name = name;
		this.city = city;
		this.email = email;
		this.sex = sex;
		this.age = age;
		this.marks = marks;
	}
	public Student() {
		
	}
	
}
