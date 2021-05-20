package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.aop.LoggingAspect;
import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
@Api("HappyHouse API V1")
@CrossOrigin("*")
public class UserRestController {

	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	private UserService userService;

	@ApiResponses({ @ApiResponse(code = 200, message = "회원등록 OK"),
			@ApiResponse(code = 404, message = "페이지가 존재하지 않습니다."), @ApiResponse(code = 500, message = "서버에러") })

	@PostMapping(value = "/login")
	public ResponseEntity<MemberDto> login(@RequestParam Map<String, String> map, Model model, HttpSession session,
			HttpServletResponse response) {
		try {
			MemberDto memberDto = userService.login(map);
			if (memberDto != null) {
				logger.info(memberDto.toString());
				session.setAttribute("userinfo", memberDto);

				Cookie cookie = new Cookie("ssafy_id", memberDto.getUserid());
				cookie.setPath("/");
				if ("saveok".equals(map.get("idsave"))) {
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);// 40년간 저장.
				} else {
					cookie.setMaxAge(0);
				}
				response.addCookie(cookie);

				return new ResponseEntity(HttpStatus.OK);
			} else
				return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "회원가입", notes = "회원 정보를 받아서 DB에 저장.")
	@PostMapping(value = "/join")
	public ResponseEntity<List<MemberDto>> userRegister(
			@ApiParam(value = "회원 한명의 정보", required = true) MemberDto memberDto) {
		logger.info(memberDto.toString());

		int cnt = userService.userRegister(memberDto);
		if (cnt != 0) {
			List<MemberDto> list = userService.userList();
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
		} else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/userList")
	public ResponseEntity<List<MemberDto>> userList() {
		logger.info("userList(): ");
		List<MemberDto> emps = userService.userList();
		try {
			if(emps != null) {
				logger.info("userInfo(): success");
				return new ResponseEntity(emps, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/userInfo")
	public ResponseEntity<MemberDto> userInfo(String userid) {
		logger.info("userInfo(): " + userid);
		MemberDto memberDto = userService.userInfo(userid);
		try {
			if (memberDto != null) {
				logger.info("userInfo(); " + memberDto.toString());
				return new ResponseEntity(memberDto, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_GATEWAY);
		}
	}

	@ApiOperation(value = "회원정보수정", notes = "회원의 정보를 수정합니다.")
	@PutMapping(value = "/modify")
	public ResponseEntity<MemberDto> userModify(
			@RequestBody @ApiParam(value = "수정 할 회원정보", required = true) MemberDto memberDto, HttpSession session) {
		userService.userModify(memberDto);
		logger.info("userModify(): " + memberDto.toString());
		MemberDto member = userService.userInfo(memberDto.getUserid());

		session.setAttribute("userinfo", member);
		return new ResponseEntity<>(member, HttpStatus.OK);
	}

	@ApiOperation(value = "회원정보삭제", notes = "회원의 정보를 삭제합니다.")
//	@Transactional
	@DeleteMapping(value = "/delete/{userid}")
	public ResponseEntity userDelete(@PathVariable("userid") @ApiParam(value = "삭제 할 회원아이디") String userid) {
		logger.info("userDelete() " + userid);
		int result = userService.userDelete(userid);
		if(result > 0) {
			return new ResponseEntity(HttpStatus.OK);	
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
