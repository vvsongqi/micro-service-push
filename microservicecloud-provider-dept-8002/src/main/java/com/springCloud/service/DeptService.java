package com.springCloud.service;

import java.util.List;

import com.springCloud.entitys.Dept;

public interface DeptService {
	
	boolean add(Dept dept);
	
	Dept get(Long id);
	
	List<Dept> list();
}
