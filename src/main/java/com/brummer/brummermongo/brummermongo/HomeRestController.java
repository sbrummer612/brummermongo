package com.brummer.brummermongo.brummermongo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brummer.brummermongo.brummermongo.testtwo.TestTwoRepository;
import com.brummer.brummermongo.brummermongo.testtwo.TestTwo;


@RestController
public class HomeRestController {

	private final TestTwoRepository testTwoRepository;
	private final static String BASE_PATH = "/homeRestController";	
	
	public HomeRestController(TestTwoRepository testTwoRepository) {
		this.testTwoRepository = testTwoRepository;
	}
	
	@GetMapping(BASE_PATH + "/listAllTests")
	public Iterable<TestTwo> listTests(){
		return testTwoRepository.findAll();
	}
	
	@GetMapping(BASE_PATH + "/deleteAllTests")
	public void deleteById(){
		testTwoRepository.deleteAll();
	}
	
}
