package com.example.application.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employee;
import com.example.repository.HelloRepository;

@Service
public class HelloService {

	@Autowired
	private HelloRepository repository;

	// 従業員を1人取得する
	public Employee getEmployee(String id) {

		// 検索
		Map<String, Object> map = repository.findById(id);

		// Mapから値を取得
		String employeeId = (String)map.get("id");
		String name = (String)map.get("name");
		int age = (Integer)map.get("age");

		// Employeeクラスに値をセット
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setName(name);
		employee.setAge(age);

		return employee;
	}
}
