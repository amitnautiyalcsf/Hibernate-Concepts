package com.mychannel.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentData 
{

	@Id
	private int rollNo;
	private FullName name;
	private int marks;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public FullName getName() {
		return name;
	}
	public void setName(FullName name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	
	
	
	
	

}
