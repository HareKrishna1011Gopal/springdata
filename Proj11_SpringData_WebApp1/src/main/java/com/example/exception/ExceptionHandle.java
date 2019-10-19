package com.example.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(value = {NullPointerException.class,NumberFormatException.class})
	public String nullPointerException(Model model) {
		model.addAttribute("errMsg","Internal have some problem occured.Please try after sometimes..");
		return "error";
	} 
}
