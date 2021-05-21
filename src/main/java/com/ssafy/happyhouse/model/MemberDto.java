package com.ssafy.happyhouse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MemberDto : 회원정보", description = "회원의 아이디, 이름, 비번, 이메일, 폰 번호, 주소, 가입일등을 설정합니다.")
public class MemberDto {

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", tel=" + tel
				+ ", address=" + address + "]";
	}

	@ApiModelProperty(value = "회원 아이디")
	private String id;
	@ApiModelProperty(value = "비밀번호")
	private String pw;
	@ApiModelProperty(value = "회원 이름")
	private String name;
	@ApiModelProperty(value = "이메일 주소")
	private String email;
	@ApiModelProperty(value = "폰 번호")
	private String tel;
	@ApiModelProperty(value = "주소")
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	


	
	

}
