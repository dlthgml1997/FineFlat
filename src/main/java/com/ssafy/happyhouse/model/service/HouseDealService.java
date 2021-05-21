package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.util.PageNavigation;

public interface HouseDealService {
	List<HouseDealDto> getSido();
	List<HouseDealDto> getGugunInSido(String sido);
	List<HouseDealDto> getDongInGugun(String gugun);
	List<HouseDto> searchByDong(String totalcode) throws SQLException;
	List<HouseDto> searchByName(String searchWord, String dongName) throws SQLException;
	// 지도 검색 기능 구현하기
}
