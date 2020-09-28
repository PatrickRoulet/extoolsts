package be.abis.exa6.model;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	
	int personNumber;
	String firstName;
	String lastName;
	LocalDate birthday;
	Company company;
	
	public Person(int personNumber, String firstName, String lastName, LocalDate birthday) {
		super();
		this.personNumber = personNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
	}
	
	public Person(int personNumber, String firstName, String lastName, LocalDate birthday, Company company) {
		super();
		this.personNumber = personNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.company = company;
	}

	public int getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(int personNumber) {
		this.personNumber = personNumber;
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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		if (company == null) {
		   return firstName +" "+ lastName + "(" + calculateAge() + " years old) is not employed for the moment";
		} else {
		   return firstName +" "+ lastName + "(" + calculateAge() + " years old)"
					+ " works for "+company.getName()+" in "+company.getAddress().getTown();			
		}
	}
	
	public int calculateAge() {
		return Period.between(birthday, LocalDate.now()).getYears();
	}

}
