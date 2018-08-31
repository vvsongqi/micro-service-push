package com.springCloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springCloud.entitys.Dept;

@Mapper
public interface DeptDao {
	
	boolean addDept(Dept dept);
	
	Dept findById(Long id);
	
	List<Dept> findAll();
	
}
