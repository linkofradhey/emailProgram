package com.project.demo.EmailDto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDtoo {
	private String from;
	private List<String> to;

	private String subject;

	private String body;

}
