package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.ArticleDto;

public interface BoardMapper {

//	public ArticleDto login(Map<String, String> map) throws SQLException;
	
//	REST
	public List<ArticleDto> readArticles();
	public ArticleDto detailArticle(int no);
	public int writeArticle(ArticleDto ArticleDto);
	public int updateArticle(ArticleDto ArticleDto);
	public int deleteArticle(int no);
}
