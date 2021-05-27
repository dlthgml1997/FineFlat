package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.ArticleDto;
import com.ssafy.happyhouse.model.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/board")
@Api("HappyHouse API V1")
@CrossOrigin("*")
public class BoardRestController {

	private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	@Autowired
	private BoardService boardService;

	@ApiResponses({ @ApiResponse(code = 200, message = "게시글 로딩완료"),
			@ApiResponse(code = 404, message = "페이지가 존재하지 않습니다."), @ApiResponse(code = 500, message = "서버에러") })

    @ApiOperation(value = "모든 게시글의 목록를 반환한다.", response = List.class)
	@GetMapping(value = "/readlist")
	public ResponseEntity<List<ArticleDto>> readArticles() throws Exception {
		logger.info("readArticles - 호출");
		return new ResponseEntity<List<ArticleDto>>(boardService.readArticles(), HttpStatus.OK);
	}

    @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 반환한다.", response = ArticleDto.class)    
	@GetMapping("/read/{no}")
	public ResponseEntity<ArticleDto> detailArticle(@PathVariable int no) {
		logger.info("detailArticle - 호출");
		return new ResponseEntity<ArticleDto>(boardService.detailArticle(no), HttpStatus.OK);
	}

    @ApiOperation(value = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping(value="/create")
	public ResponseEntity<String> writeArticle(@RequestBody ArticleDto articleDto) {
		logger.info("writeArticle - 호출");
		if (boardService.writeArticle(articleDto)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/modify/{no}")
	public ResponseEntity<String> updateArticle(@RequestBody ArticleDto articleDto) {
		logger.info("ArticleDto - 호출");
		logger.debug("" + articleDto);
		
		if (boardService.updateArticle(articleDto)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/delete/{no}")
	public ResponseEntity<String> deleteArticle(@PathVariable int no) {
		logger.info("deleteArticle - 호출");
		if (boardService.deleteArticle(no)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}
