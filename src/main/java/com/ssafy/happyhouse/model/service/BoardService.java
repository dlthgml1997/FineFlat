package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.ArticleDto;
import com.ssafy.happyhouse.model.MemberDto;

public interface BoardService {

	//public ArticleDto login(Map<String, String> map) throws Exception;
	
//	REST 
	public List<ArticleDto> readArticles();

	  public ArticleDto detailArticle(int no); 
	  public int writeArticle(ArticleDto articleDto); 
	  public int updateArticle(ArticleDto articleDto);
	  public int deleteArticle(int no);
	
}
