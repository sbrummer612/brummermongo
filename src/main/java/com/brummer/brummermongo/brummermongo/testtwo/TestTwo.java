package com.brummer.brummermongo.brummermongo.testtwo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class TestTwo {

	@Id
	private String id;
	private String name;
	
	public TestTwo(String name) {
		this.name = name;
	}
	
}
