package be.abis.courseadmin.model;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Instructor {

	private String firstName;
	private String lastName;
	private int age=0;

	public Instructor(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
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

	public void setAge(int age) {
		this.age = age;
	}

	public void printSalaryHistory(int currentAge, int startingAge, double startingSalary) {
		int workingAge = startingAge;
		double workingSalary = startingSalary;
		BufferedWriter bufferedWriter = null;
		try {
			Path pathToFile= Paths.get("salaryhistory.txt");
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

}
