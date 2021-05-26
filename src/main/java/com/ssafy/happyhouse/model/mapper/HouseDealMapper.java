package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.BaseAddressDto;
import com.ssafy.happyhouse.model.HouseDto;

public interface HouseDealMapper {
	// 시, 도 검색
	List<BaseAddressDto> getSido();

	// 시, 도 코드를 통해 구, 군 검색
	List<BaseAddressDto> getGugunInSido(String sido);

	// 구, 군 코드를 이용해 동 검색
	List<BaseAddressDto> getDongInGugun(String gugun);

	// 지도 - 동으로 검색
	List<HouseDto> searchByDong(String totalcode) throws SQLException;

	// 아파트명으로 검색
	List<HouseDto> searchByName(String searchName) throws SQLException;

	// 클릭 횟수 증가
	int clickCntModify(int no);

	// 조회수 상위 5개 반환
	List<HouseDto> getMostClicked();
}
