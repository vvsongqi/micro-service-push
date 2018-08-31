package com.springCloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springCloud.dao.DeptDao;
import com.springCloud.entitys.Dept;
import com.springCloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptDao dao;
	
	@Override
	public boolean add(Dept dept) {
		return dao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Dept> list() {
		return dao.findAll();
	}
 
}
