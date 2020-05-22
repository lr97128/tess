package com.lr97128.tess.biz;

public class Person {
	private int id;
	private Student stu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", stu=" + stu + "]";
	}
	
}
