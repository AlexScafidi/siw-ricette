package it.uniroma3.siw.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class GlobalController {

	@GetMapping(value="/")
	public String index() {
		return "all/index.html";
	}
}
