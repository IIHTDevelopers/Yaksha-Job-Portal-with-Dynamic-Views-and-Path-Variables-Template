package com.yaksha.assignment.models;

public class Job {

	private int id;
	private String title;
	private String department;
	private double salary;

	// Constructor
	public Job(int id, String title, String department, double salary) {
		this.id = id;
		this.title = title;
		this.department = department;
		this.salary = salary;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", department=" + department + ", salary=" + salary + "]";
	}
}
