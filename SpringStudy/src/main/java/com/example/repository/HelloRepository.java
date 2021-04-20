package com.example.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {

	@Autowired
	private JdbcTemplate idbcTemplate;

	public Map<String, Object>findById(String id) {

		// SQL
		String query = "SELECT *"
				+ " FROM employee"
				+ " WHERE id=?";

		// 検索実行
		Map<String, Object> employee = idbcTemplate.queryForMap(query, id);

		return employee;
	}
}
