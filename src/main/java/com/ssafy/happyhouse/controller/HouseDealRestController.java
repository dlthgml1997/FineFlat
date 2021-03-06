package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ssafy.happyhouse.model.BaseAddressDto;
import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.happyhouse.model.service.HouseDealService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 *
 * 아파트 실거래가 관련 기능
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

	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "페이지가 존재하지 않습니다."),
			@ApiResponse(code = 500, message = "서버에러") })

	@ApiOperation(value = "도시명 얻기", notes = "DB에 있는 도시코드와 도시명을 반환합니다.")
	@GetMapping("/sido")
	private ResponseEntity<List<BaseAddressDto>> getSido() {
		logger.info("getSido");
		try {
			List<BaseAddressDto> list = houseDealService.getSido();
			if (list.size() > 0) {
				return new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "구군명 얻기", notes = "해당도시의 구군명을 반환합니다.")
	@GetMapping("/gugun/{sido}")
	public ResponseEntity<List<BaseAddressDto>> getGugunInSido(@PathVariable("sido") String sido) {
		logger.info("getGugunInSido");
		logger.info(sido);

		try {
			List<BaseAddressDto> list = houseDealService.getGugunInSido(sido);
			if (list.size() > 0) {
				return new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "동명 얻기", notes = "해당 구군의 동명을 반환합니다.")
	@GetMapping("/dong/{sigugun}")
	public ResponseEntity<List<BaseAddressDto>> getDongInGugun(@PathVariable("sigugun") String sigugun) {
		logger.info("getDongInGugun");
		logger.info(sigugun);
		try {
			List<BaseAddressDto> list = houseDealService.getDongInGugun(sigugun);
			if (list.size() > 0) {
				logger.info("getDongInGugun  sss");
				return new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "아파트 리스트 얻기", notes = "해당 동의 아파트 리스트를 반환합니다.")
	@GetMapping("/dongApt/{totalcode}")
	public ResponseEntity<List<HouseDto>> searchByDong(@PathVariable("totalcode") String totalcode) {
		logger.info("searchByDong");
		logger.info(totalcode);
		try {
			List<HouseDto> list = houseDealService.searchByDong(totalcode);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "아파트명으로 검색", notes = "아파트명으로 아파트를 검색합니다.")
	@GetMapping("/searchName/{searchName}")
	public ResponseEntity<List<HouseDto>> searchByName(@PathVariable("searchName") String searchName) {
		logger.info("searchByName: " + searchName  );
		logger.info(searchName);
		try {
			List<HouseDto> list = houseDealService.searchByName(searchName);

			return new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "아파트 상세 조회 클릭 횟수 1씩 증가시키기", notes ="아파트 no로 클릭 횟수를 증가시킵니다.")
	@PutMapping(value = "/click/{no}")
	public ResponseEntity clickUpdate(@PathVariable @ApiParam(value="클릭 된 아파트의 no", required = true) Integer no) {
		logger.info("clickUpdate no: "+no);
		int result = houseDealService.clickCntModify(no);
		logger.info("clickUpdate result: "+result);
		if(result > 0) {
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "아파트 조회 클릭 수 상위 5개 얻기", notes="아파트 조회 클릭 수 상위 5개의 정보를 반환합니다.")
	@GetMapping(value ="/mostclicked")
	public ResponseEntity<List<HouseDto>> getMostClicked() {
		try {
			List<HouseDto> list = houseDealService.getMostClicked();
			logger.info("getMostClicked list: "+ list.toString());
			return new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
