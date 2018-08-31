package com.springCloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springCloud.entitys.Dept;
import com.springCloud.service.DeptClientService;

/**
 * 消费者
 * @author Administrator
 */
@RestController
public class DeptController_Consumer {
	
	@Autowired
	private DeptClientService deptClientService;
	
	@PostMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		return deptClientService.add(dept);
	}
	
	@GetMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return deptClientService.get(id);
	}
	
	@GetMapping(value="/consumer/dept/list")
	public List<Dept> list() {
		return deptClientService.list();
	}
}
