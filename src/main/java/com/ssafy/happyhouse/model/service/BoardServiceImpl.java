package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.ArticleDto;
import com.ssafy.happyhouse.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
//	@Override
//	public ArticleDto login(Map<String, String> map) throws Exception { 
//		if(map.get("id") == null || map.get("pw") == null) 
//			return null;
//		return sqlSession.getMapper(UserMapper.class).login(map);
//	}

	@Override
	public List<ArticleDto> readArticles() {
		logger.info("영린");
		List<ArticleDto> list =sqlSession.getMapper(BoardMapper.class).readArticles();
		logger.info(list.toString());
		return list;
	}

	@Override
	public ArticleDto detailArticle(int no) {
		return sqlSession.getMapper(BoardMapper.class).detailArticle(no);
	}

	@Override
	public int writeArticle(ArticleDto articleDto) {
		return sqlSession.getMapper(BoardMapper.class).writeArticle(articleDto);
	}

	@Override
	public int updateArticle(ArticleDto articleDto) {
		return sqlSession.getMapper(BoardMapper.class).updateArticle(articleDto);
	}

	@Override
	public int deleteArticle(int no) {
		return sqlSession.getMapper(BoardMapper.class).deleteArticle(no);
	}
}
