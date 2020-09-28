package be.abis.courseadmin.model;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;

import be.abis.courseadmin.exception.AgeCannotBeNegativeException;

public class Instructor {

	private String firstName;
	private String lastName;
	private int age=0;
	private LocalDate birthday;

	public Instructor(String firstName, String lastName, int age) throws AgeCannotBeNegativeException {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.setAge(age);
	}

	public Instructor(String firstName, String lastName, LocalDate birthday) throws AgeCannotBeNegativeException {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.setBirthday(birthday);
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws AgeCannotBeNegativeException {
		if (age < 0) {
			throw new AgeCannotBeNegativeException("Age cannot be negative : "+age);
		}
		this.age = age;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) throws AgeCannotBeNegativeException {
		this.birthday = birthday;
		Period period = Period.between(birthday, LocalDate.now());
		this.setAge(period.getYears());
	}

	public void printSalaryHistory(int currentAge, int startingAge, double startingSalary) {
		printSalaryHistory(currentAge, startingAge, startingSalary, "salaryhistory.txt");
	}

	public void printSalaryHistory(int currentAge, int startingAge, double startingSalary, String outputName) {
		int workingAge = startingAge;
		double workingSalary = startingSalary;
		BufferedWriter bufferedWriter = null;
		try {
			Path pathToFile= Paths.get(outputName);
			bufferedWriter = Files.newBufferedWriter(pathToFile);
			while (workingAge < (startingAge+36) && workingAge < (currentAge+1)) {
				bufferedWriter.write("Salary of "+firstName+" at "+workingAge+" is "+workingSalary+"\n");
				workingSalary+=workingSalary*0.03;
				workingAge+=5;
			}
			if (workingAge > startingAge+35) {
				bufferedWriter.write("Maximum salary reached");
			}
		} catch (IOException except) {
			except.printStackTrace();
		}
		try {
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
		} catch (IOException except) {
			except.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return "Instructor [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

}
