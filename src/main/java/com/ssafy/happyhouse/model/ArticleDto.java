package com.ssafy.happyhouse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ArticleDto : 글정보", description = "글 번호, 종류, 작성자, 제목, 내용, 작성시간등을 설정합니다.")
public class ArticleDto {

	@Override
	public String toString() {
		return "ArticleDto [no=" + no + ", writer=" + writer + ", sort=" + sort + ", title=" + title + ", content="
				+ content + ", regtime=" + regtime + "]";
	}

	@ApiModelProperty(value = "번호")
	private String no;
	@ApiModelProperty(value = "작성자")
	private String writer;
	@ApiModelProperty(value = "종류")
	private String sort;
	@ApiModelProperty(value = "제목")
	private String title;
	@ApiModelProperty(value = "내용")
	private String content;
	@ApiModelProperty(value = "작성시간")
	private String regtime;
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	

	


	
	

}
