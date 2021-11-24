package com.tanmay.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	private int id;
	private String name;
	private int mob_num;
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
	public int getMob_num() {
		return mob_num;
	}
	public void setMob_num(int mob_num) {
		this.mob_num = mob_num;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", mob_num=" + mob_num + "]";
	}
	
}
