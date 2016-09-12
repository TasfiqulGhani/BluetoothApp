package com.buddybear;

public class Weeks {

	private String name;
	private String semester;
	private String grade;
	private String credit;

	public Weeks(String name, String semester ,String grade, String credit  ) {
		this.name = name;
		this.semester = semester;
		this.grade = grade;
		this.credit = credit;
	}

	public String getName() {
		return this.name;
	}

	public String getSemester() {
		return this.semester;
	}

	public String getGrade() {
		return this.grade;
	}

	public String getCredit() {
		return this.credit;
	}
	
}
