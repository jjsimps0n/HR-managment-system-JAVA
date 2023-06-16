package com.example.demo.employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.extensions.*;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<ErrorMessageHandler> result = new ArrayList<>();
	
	@Query("SELECT e FROM Employee e WHERE e.departmentID = ?1")
	List<Employee> findByDepartmentID(Long departmentID);
	
	
	/**
	* Return a manipulated name with rules:
	* First word letter should be upperCase
	* If name have two words should return first word with upper case letter and second word first letter in upper case
	* If name have more then 2 words. Words will be ignored
	* Example
	* Input: jasica shy
	* Output Jasica S
	*
	* @param  name  Name or text to manipulate
	*/
	 public static String manipulateName(String name) {
	        String[] words = name.split(" ");
	        if (words.length > 1) {
	            String firstWord = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);
	            String secondWord = words[1];
	            String capitalizedSecondWord = Character.toUpperCase(secondWord.charAt(0)) + secondWord.substring(1);
	            return firstWord + " " + capitalizedSecondWord.substring(0, 1);
	        }
	        return name.substring(0, 1).toUpperCase() + name.substring(1);
	    }
	 
	 public static List<ErrorMessageHandler> validateName(String name) {
		 name = name.trim();
		 String[] words = name.split("\\s+");
		 for (String word : words) {
		        if (!word.matches("[a-zA-Z]+")) {
		        	ErrorMessageHandler error = new ErrorMessageHandler(false, "Name can't have special characters!"); 
		        	result.add(error);
		        }
		        if(!validateTextLength(word, 2)) {
		        	ErrorMessageHandler error = new ErrorMessageHandler(false, "Name too short, atleast 2 characters or numbers!"); 
		        	result.add(error);
		        }
		  }
		 
		 return result;
	 }
	 
	 public static boolean validateTextLength(String name, int length) {
		 if (name.length() < length) {
		        return false;
		    }
		 return true;
	 }
	 
	 public static List<ErrorMessageHandler> validateSalary(double salary, double min, double max) {
		 if (salary >= max || salary <= min) {
			 System.out.println(salary + " path:" + max + " - " + min);
			 ErrorMessageHandler error = new ErrorMessageHandler(false, "Salary should be between " + min + " and " + max + "!"); 
			 result.add(error);
		 }
		 return result;
	 }
}
