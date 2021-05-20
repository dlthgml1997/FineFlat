package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.happyhouse.model.service.HouseDealService;

import io.swagger.annotations.Api;


/**
 *
 *  아파트 실거래가 관련 기능
 *
 */
@RestController
@RequestMapping("/house")
@Api("HappyHouse API V1")
@CrossOrigin("*")
public class HouseDealRestController {

	private static final Logger logger = LoggerFactory.getLogger(HouseDealRestController.class);
	
	@Autowired
	private HouseDealService houseDealService;
	
	
	@GetMapping("/sido")
	private ResponseEntity<List<HouseDealDto>> getSido() {
		logger.info("getSido");
		try {
			List<HouseDealDto> list = houseDealService.getSido();
			if(list.size() > 0) {
				return new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/gugun/{sido}")
	public ResponseEntity<List<HouseDealDto>> getGugunInSido(@PathVariable("sido") String sido) {
		logger.info("getGugunInSido");
		logger.info(sido);
		
		try {
			List<HouseDealDto> list = houseDealService.getGugunInSido(sido);
			if(list.size() > 0) {
				return new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
	}
	
	@GetMapping("/dong/{gugun}")
	public ResponseEntity<List<HouseDealDto>> getDongInGugun(@PathVariable("gugun") String gugun) {
		logger.info("getDongInGugun");
		logger.info(gugun);
		try {
			List<HouseDealDto> list = houseDealService.getDongInGugun(gugun);
			if(list.size() > 0) {
				logger.info("getDongInGugun  sss");
				return new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/dongApt/{totalcode}")
	public ResponseEntity<List<HouseDto>> searchByDong(@PathVariable("totalcode") String totalcode) {
		logger.info("searchByDong");
		logger.info(totalcode);
		try {
			List<HouseDto> list = houseDealService.searchByDong(totalcode);

				logger.info("searchByDong sss");
				return new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/searchDong/{searchWord}")
	public ResponseEntity<List<HouseDto>> searchByDongName(@PathVariable("searchWord") String searchWord) {
		logger.info("searchByDongName");
		logger.info(searchWord);
		try {
			List<HouseDto> list = houseDealService.searchByDongName(searchWord);
			
			logger.info("searchByDongName sss");
			return new ResponseEntity<>(list, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
	}
}
