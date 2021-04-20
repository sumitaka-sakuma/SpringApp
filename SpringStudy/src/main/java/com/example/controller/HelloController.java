package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Employee;
import com.example.application.service.HelloService;

@Controller
public class HelloController {

	@Autowired
	private HelloService service;

	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}

	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1")String str, Model model) {
		model.addAttribute("sample", str);
		return "response";
	}

	@PostMapping("/db")
	public String postDbRequest(@RequestParam("text2")String id, Model model) {

		// 1件検索
		Employee employee = new Employee();

		// 検索結果をModelに登録
		model.addAttribute("employee", employee);
		return "db";
	}
}