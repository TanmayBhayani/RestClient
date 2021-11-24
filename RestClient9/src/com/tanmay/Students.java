package com.tanmay;

import java.util.List;
public class Students {
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public void display() {
		int i;
		for(i=0;i<students.size();i++) 
			System.out.println(students.get(i));
		if(i==0)
			System.out.println("Empty");
	}
}
