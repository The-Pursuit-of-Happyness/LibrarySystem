package com.data;

public class Reader {
	private int readerNumber;
	private String readerName;
	private String readerPassword;
	private String readerSex;
	private int readerAge;
	private String readerPhone;
	private String readerEmail;
	private String readerTie;
	private String readerType;
	private String readerGrade;
	private String readerLimits;
	
	public Reader(int number,String name,String password,String sex,int age,String phone,
			String email,String tie,String type,String grade,String limits){
		
		this.readerNumber = number;
		this.readerName = name;
		this.readerPassword = password;
		this.readerSex = sex;
		this.readerAge = age;
		this.readerPhone = phone;
		this.readerEmail = email;
		this.readerTie = tie;
		this.readerType = type;
		this.readerGrade = grade;
		this.readerLimits = limits;
		
	}

	public int getReaderNumber() {
		return readerNumber;
	}

	public void setReaderNumber(int readerNumber) {
		this.readerNumber = readerNumber;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getReaderSex() {
		return readerSex;
	}

	public void setReaderSex(String readerSex) {
		this.readerSex = readerSex;
	}

	public String getReaderPhone() {
		return readerPhone;
	}

	public void setReaderPhone(String readerPhone) {
		this.readerPhone = readerPhone;
	}

	public int getReaderAge() {
		return readerAge;
	}

	public void setReaderAge(int readerAge) {
		this.readerAge = readerAge;
	}

	public String getReaderEmail() {
		return readerEmail;
	}

	public void setReaderEmail(String readerEmail) {
		this.readerEmail = readerEmail;
	}

	public String getReaderTie() {
		return readerTie;
	}

	public void setReaderTie(String readerTie) {
		this.readerTie = readerTie;
	}

	public String getReaderType() {
		return readerType;
	}

	public void setReaderType(String readerType) {
		this.readerType = readerType;
	}

	public String getReaderLimits() {
		return readerLimits;
	}

	public void setReaderLimits(String readerLimits) {
		this.readerLimits = readerLimits;
	}

	public String getReaderGrade() {
		return readerGrade;
	}

	public void setReaderGrade(String readerGrade) {
		this.readerGrade = readerGrade;
	}

	public String getReaderPassword() {
		return readerPassword;
	}

	public void setReaderPassword(String readerPassword) {
		this.readerPassword = readerPassword;
	}	
}
