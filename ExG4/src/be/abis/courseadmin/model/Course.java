package be.abis.courseadmin.model;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Course {
	
    private String title;
    private int numberOfDays;
    private double pricePerDay;
    private boolean priorKnowledgeRequired;
    private List<Instructor> listOfInstructors = new ArrayList<Instructor>();
    private static double VAT = 0.21;
    private String label;

    public Course(String title, int numberOfDays, double pricePerDay, boolean priorKnowledgeRequired) {
		this.title = title;
		this.numberOfDays = numberOfDays;
		this.pricePerDay = pricePerDay;
		this.priorKnowledgeRequired = priorKnowledgeRequired;
	}

    public Course() {
    	this.title = "Course per default";
    	this.numberOfDays = 3;
    	this.pricePerDay = 400.0;
    	this.priorKnowledgeRequired = false;
    	this.label = "CHEAP";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public boolean isPriorKnowledgeRequired() {
		return priorKnowledgeRequired;
	}

	public void setPriorKnowledgeRequired(boolean priorKnowledgeRequired) {
		this.priorKnowledgeRequired = priorKnowledgeRequired;
	}

	public List<Instructor> getListOfInstructors() {
		return listOfInstructors;
	}

	public void setListOfInstructors(List<Instructor> listOfInstructors) {
		this.listOfInstructors = listOfInstructors;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public static double getVAT() {
		return VAT;
	}

    public double calculateTotalPrice() {
    	double totalPrice = numberOfDays * pricePerDay;
    	if (numberOfDays > 3 && priorKnowledgeRequired) {
    		System.out.println("Number of days > 3 and prior knowledge required => no VAT");
    	} else {
    		System.out.println("Number of days <= 3 or prior knowledge not required => VAT applied");
    		totalPrice *= (1+VAT);
    	}
		if (totalPrice < 500.0) {
			this.setLabel("CHEAP");
		} else if (totalPrice > 1500.0) {
			this.setLabel("EXPENSIVE");
		} else {
			this.setLabel("OK");
		}
		return totalPrice;
    }

	public void printInfo(BufferedWriter bufferedWriter) throws IOException {
		bufferedWriter.write("Title : "+title+"\n");
		bufferedWriter.write("Number of days : "+ numberOfDays+"\n");
		bufferedWriter.write("Price per day : "+ pricePerDay+"\n");
		bufferedWriter.write("Prior knowledge required : "+ priorKnowledgeRequired +"\n");
		bufferedWriter.write("Number of instructors : "+ listOfInstructors.size()+"\n");
		for (Instructor instructor : listOfInstructors) {
			bufferedWriter.write(instructor.toString()+"\n");
		}
		bufferedWriter.write("Total price : "+ this.calculateTotalPrice() + " ("+label+")\n");
		bufferedWriter.write("=======================================================================\n");
	}

	public void addInstructor(Instructor instructor) {
		listOfInstructors.add(instructor);
	}

	public void removeInstructor(int index) {
		listOfInstructors.remove(index);
	}

}
