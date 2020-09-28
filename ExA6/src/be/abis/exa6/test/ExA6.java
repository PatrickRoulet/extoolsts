package be.abis.exa6.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import be.abis.exa6.model.Address;
import be.abis.exa6.model.Company;
import be.abis.exa6.model.Person;

public class ExA6 {

	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<Person>();
		Address address1 = new Address("Streer", "2", "3000", "Leuven", "Belgium", "BE");
		Company company1 = new Company("ABIS", address1);
		persons.add(new Person(1, "Ann", "Smits", LocalDate.of(1985, 5, 23), company1));
		persons.add(new Person(2, "John", "Dow", LocalDate.of(1966, 6, 13)));
		
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("personinfo.txt"))) {
			for (Person person:persons) {
				bufferedWriter.write("Person "+person.getPersonNumber()+" : "+person+"\n");
			}
		} catch (IOException except) {
			except.printStackTrace();
		}

	}

}
