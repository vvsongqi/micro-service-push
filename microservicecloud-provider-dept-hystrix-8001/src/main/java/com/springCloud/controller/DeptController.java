package com.springCloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springCloud.entitys.Dept;
import com.springCloud.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}
	
	@GetMapping(value="/dept/get/{id}")
	@HystrixCommand(fallbackMethod="processHystrix_Get")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = deptService.get(id);
		if (dept == null) {
			throw new RuntimeException("该ID"+id+"没有对应的信息");
		}
		return dept;
	}
	
	@GetMapping(value="/dept/list")
	public List<Dept> list() {
		return deptService.list();
	}
	
	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		Dept dept = new Dept();
		dept.setDeptno(id);
		dept.setDname("该ID:"+id+"没有对应的信息,null--@HystrixCommand");
		dept.setDb_source("no this database in MySql");
		return dept;
	}
}
