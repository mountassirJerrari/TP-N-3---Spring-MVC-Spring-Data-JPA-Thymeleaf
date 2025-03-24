package com.example.tp3;

import com.example.tp3.entities.Patient;
import com.example.tp3.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tp3Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp3Application.class, args);
	}

	@Bean
	CommandLineRunner start(PatientRepository patientRepository){
		return args ->
		{
			patientRepository.save(new Patient());
			patientRepository.save(new Patient());
			patientRepository.save(new Patient());
			patientRepository.save(new Patient());
			patientRepository.save(new Patient());
			patientRepository.save(new Patient());
			patientRepository.save(new Patient());
			patientRepository.save(new Patient());
			patientRepository.save(new Patient());

		};
	}

}
