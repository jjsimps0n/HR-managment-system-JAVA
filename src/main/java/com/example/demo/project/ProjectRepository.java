package com.example.demo.project;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.extensions.*;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	List<ErrorMessageHandler> result = new ArrayList<>();
	
	 public static void checkDueDate(LocalDate startDate, LocalDate dueDate) {
	 	boolean isWithinOneYear = startDate.isBefore(dueDate.minusYears(1)); 
        if (isWithinOneYear) {
        	new ErrorMessageHandler(false, "Due date can't be higher the 1 year!");
        }
	 }
	
}

