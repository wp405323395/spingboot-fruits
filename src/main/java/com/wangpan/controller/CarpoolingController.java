package com.wangpan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangpan.entity.Carpooling;
import com.wangpan.service.CarpoolingService;

@RestController
@RequestMapping("/carpooling")
public class CarpoolingController {
	
	@Autowired 
	CarpoolingService carpoolingService;
	
	// curl http://localhost:8986/fruits/carpooling/queryAllCarpooling
	@GetMapping("/queryAllCarpooling")
	public Object queryAllCarpooling() {
		return carpoolingService.getCarpoolingDetail();
	}
	
	// curl -H "Content-Type: application/json" -X POST  --data '{"carPoolingName":"shufengchela", "createBy":"5", "startSiteId": "1", "endSiteId":"2"}' http://127.0.0.1:8986/fruits/carpooling/createCarpooling
	@PostMapping("/createCarpooling")
	public Object createCarpooling(@RequestBody Carpooling carpooling) {
		return carpoolingService.createCarpooling(carpooling);
		
	}
}
