package be.abis.courseadmin.test;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import be.abis.courseadmin.exception.AgeCannotBeNegativeException;
import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.model.Instructor;

public class ExG4 {

	public static void main(String[] args) {
		
		BufferedWriter bufferedWriter = null;
		try {
			Path pathToFile= Paths.get("courseinfo.txt");
			bufferedWriter = Files.newBufferedWriter(pathToFile);
		} catch (IOException except) {
			except.printStackTrace();
		}
		
		List<Instructor> instructors = new ArrayList<Instructor>();
		try {
			instructors.add(new Instructor("Bruno", "Zeghers", 58));
			instructors.add(new Instructor("Patrick", "Roulet", 47));
			instructors.add(new Instructor("Philippe", "Peeters", 52));
			instructors.add(new Instructor("Vincent", "Hautain", LocalDate.of(1977, 5, 23)));			
			instructors.add(new Instructor("Test", "NegativeAge", -34));
		} catch (AgeCannotBeNegativeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Number of instructors created : "+instructors.size());
		System.out.println("-----------------------------------------------------------");
		for (Instructor instructor : instructors) {
			System.out.println(instructor.toString());
		}
		System.out.println("-----------------------------------------------------------");
		
		instructors.get(0).printSalaryHistory(58, 21, 2200.0);	
		instructors.get(1).printSalaryHistory(47, 22, 2500.0,"salaryHisPR.txt");
		
		Course course1 = new Course("Java",3,200.0,false);
		course1.addInstructor(instructors.get(0));
		course1.addInstructor(instructors.get(1));
		try {
			course1.printInfo(bufferedWriter);
		} catch (IOException except) {
			except.printStackTrace();
		}
        System.out.println("Title : "+course1.getTitle());
        System.out.println("Number of days : "+ course1.getNumberOfDays());
        System.out.println("Price per day : "+ course1.getPricePerDay());
        System.out.println("Prior knowledge required : "+ course1.isPriorKnowledgeRequired());
		
		Course course2 = new Course("HTML",5,180.0,true);		
		course2.addInstructor(instructors.get(1));
		course2.addInstructor(instructors.get(2));
		try {
			course2.printInfo(bufferedWriter);
		} catch (IOException except) {
			except.printStackTrace();
		}
        System.out.println("Title : "+course2.getTitle());
        System.out.println("Number of days : "+ course2.getNumberOfDays());
        System.out.println("Price per day : "+ course2.getPricePerDay());
        System.out.println("Prior knowledge required : "+ course2.isPriorKnowledgeRequired());

        try {
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
		} catch (IOException except) {
			except.printStackTrace();
		}

	}

}