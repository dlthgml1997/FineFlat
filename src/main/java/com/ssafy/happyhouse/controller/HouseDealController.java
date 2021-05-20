package com.ssafy.happyhouse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ssafy.happyhouse.model.service.HouseDealService;


/**
 *
 *  아파트 실거래가 관련 기능
 *
 */
@Controller
@RequestMapping("/house")
public class HouseDealController {

	private static final Logger logger = LoggerFactory.getLogger(HouseDealController.class);
	
	@Autowired
	private HouseDealService houseDealService;
	
	@GetMapping("/aptSearch")
	private String aptSearch() {
		return "housedeal/aptSearch";
	}
	
	@GetMapping("/mapSearch")
	private String mapSearch() {
		return "housedeal/mapSearch";
	}
}
