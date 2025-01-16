package com.exercise.no.repeat;

import com.exercise.no.repeat.services.RemoveDuplicatesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class NoRepeatApplication implements CommandLineRunner {

	@Autowired
	private RemoveDuplicatesServiceImpl removeDuplicatesService;

	public static void main(String[] args) {
		SpringApplication.run(NoRepeatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean isRunning = false;
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("Enter a string to remove repeated characters from:");
			String stringInput = scanner.nextLine();
			String response = "";
			try {
				response = removeDuplicatesService.removeDuplicates(stringInput);
			}catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
				continue;
			}
			System.out.println("The string without repeated characters is: " + response);
			System.out.println();
			System.out.println("Do you want to remove repeated characters from another string ? YES: Y");
			String inputFlow = scanner.nextLine();
			isRunning = inputFlow.equalsIgnoreCase("Y");
		}while (isRunning);
	}
}
