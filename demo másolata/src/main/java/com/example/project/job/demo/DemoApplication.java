package com.example.project.job.demo;

import com.example.project.job.demo.model.Ad;
import com.example.project.job.demo.repository.AdRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AdRepository adRepository) {
		return args -> {

			Ad ad1 = new Ad();
			ad1.setTitle("Példa hirdetés");
			ad1.setText("Ez egy példa hirdetés szövege");
			ad1.setAuthor("Példa Szerző");
			ad1.setCreatedDate(new Date());
			adRepository.save(ad1);

		};
	}
}
