package com.student;


public class Student implements Stream{
	private int id;
	private String firstName;
	private String lastName;
	
	public Student(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	private void fullName() {
		System.out.println(firstName + " " + lastName);
	}

	@Override
	public void streamName() {
		System.out.println("CSE");
		
	}
}
