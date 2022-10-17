package com.brummer.brummermongo.brummermongo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brummer.brummermongo.brummermongo.testtwo.TestTwo;
import com.brummer.brummermongo.brummermongo.testtwo.TestTwoRepository;

@Controller
public class HomeController {

	private final static String BASE_PATH = "/homeController";
	private final TestTwoRepository testTwoRepository;
	
	public HomeController(TestTwoRepository testTwoRepository) {
		this.testTwoRepository = testTwoRepository;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("extra", "This application uses SpringBoot, Spring Data MongoDB, Spring Web (MVC), Thymeleaf MVC , lombok, MongoDB instance is needed and is external.");
		return "index";
	}
	
	@RequestMapping( BASE_PATH + "/listTests")
	public String listTest(Model model) {
		model.addAttribute("tests", testTwoRepository.findAll());
		return "testsList";
	}
	
	@GetMapping( BASE_PATH + "/deleteTest")
	public String deleteTest(@RequestParam String id) {
		testTwoRepository.deleteById(id);
		return "redirect:"+BASE_PATH+"/listTests";
	} 
	
	@PostMapping( BASE_PATH + "/updateTest")
	public String updateTest(TestTwo updateTest) {
		testTwoRepository.save(updateTest);
		return "redirect:"+BASE_PATH+"/listTests";
	} 
	
	@PostMapping( BASE_PATH + "/addTest")
	public String addTest(TestTwo newTest) {
		testTwoRepository.save(newTest);
		return "redirect:"+BASE_PATH+"/listTests";
	}
	
}
