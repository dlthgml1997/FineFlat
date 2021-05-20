package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseDto;

public interface HouseDealMapper {
	List<HouseDealDto> getSido();
	List<HouseDealDto> getGugunInSido(String sido);
	List<HouseDealDto> getDongInGugun(String gugun);
	List<HouseDealDto> searchByAptName(String AptName) throws SQLException;
	List<HouseDto> searchByDong(String totalcode) throws SQLException;
	List<HouseDto> searchByDongName(String searchWord) throws SQLException;
	// 지도 검색 기능 구현하기
}
