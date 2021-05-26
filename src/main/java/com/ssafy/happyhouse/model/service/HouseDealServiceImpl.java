package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.happyhouse.model.mapper.HouseDealMapper;
import com.ssafy.util.PageNavigation;

@Service
public class HouseDealServiceImpl implements HouseDealService {

	private static final Logger logger = LoggerFactory.getLogger(HouseDealServiceImpl.class);

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<HouseDto> searchByDong(String totalcode) throws SQLException {
		return sqlSession.getMapper(HouseDealMapper.class).searchByDong(totalcode);
	}

	@Override
	public List<HouseDto> searchByName(String searchName) throws SQLException {
		return sqlSession.getMapper(HouseDealMapper.class).searchByName(searchName);
	}

	@Override
	public List<HouseDealDto> getSido() {
		return sqlSession.getMapper(HouseDealMapper.class).getSido();
	}

	@Override
	public List<HouseDealDto> getGugunInSido(String sido) {
		return sqlSession.getMapper(HouseDealMapper.class).getGugunInSido(sido);
	}

	@Override
	public List<HouseDealDto> getDongInGugun(String sigugun) {
		return sqlSession.getMapper(HouseDealMapper.class).getDongInGugun(sigugun);
	}

	@Override
	public int clickCntModify(int no) {
		return sqlSession.getMapper(HouseDealMapper.class).clickCntModify(no);
	}

	@Override
	public List<HouseDto> getMostClicked() {
		return sqlSession.getMapper(HouseDealMapper.class).getMostClicked();
	}
}
