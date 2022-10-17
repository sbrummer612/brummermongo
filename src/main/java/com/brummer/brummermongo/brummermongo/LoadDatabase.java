package com.brummer.brummermongo.brummermongo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.brummer.brummermongo.brummermongo.testtwo.TestTwo;
import com.brummer.brummermongo.brummermongo.testtwo.TestTwoRepository;

@Configuration
public class LoadDatabase {

	@Bean
	CommandLineRunner init(TestTwoRepository testTwoRepository) {
		
		CommandLineRunner cl = new CommandLineRunner() {
				
			@Override
			public void run(String... args) throws Exception {
				
				Arrays.asList(
						new TestTwo("testtwo1"), 
						new TestTwo("testtwo2"))
					.forEach(testTwoRepository::save);
				
			}
		};
		
		return cl;
		
	}
}
