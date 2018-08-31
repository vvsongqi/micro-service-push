package com.springCloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springCloud.entitys.Dept;

/**
 * 消费者
 * @author Administrator
 *
 */
@RestController
public class DeptController_Consumer {
	
//	private static final String REST_URL_PREFIX = "http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
	
	/**
	 * 使用restTemplate访问restful接口非常粗暴无脑。
	 * （url,requestMap,ResponseBean.class）
	 * 这三个参数分别代表rest请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate  restTemplate;
	
	@PostMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		String url = REST_URL_PREFIX+"/dept/add";
		return restTemplate.postForObject(url, dept, boolean.class);
	}
	
	@GetMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		String url = REST_URL_PREFIX+"/dept/get/"+id;
		return restTemplate.getForObject(url, Dept.class);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(value="/consumer/dept/list")
	public List<Dept> get() {
		String url = REST_URL_PREFIX+"/dept/list";
		return restTemplate.getForObject(url, List.class);
	}
	
}
