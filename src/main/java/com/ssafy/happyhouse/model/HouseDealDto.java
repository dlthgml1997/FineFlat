package com.ssafy.happyhouse.model;

public class HouseDealDto {

	private String sido_code;
	private String sido_name;
	private String gugun_code;
	private String gugun_name;
	private String dong;
	private String code;
	private String housename;

	public String getSido_code() {
		return sido_code;
	}

	public void setSido_code(String sido_code) {
		this.sido_code = sido_code;
	}

	public String getSido_name() {
		return sido_name;
	}

	public void setSido_name(String sido_name) {
		this.sido_name = sido_name;
	}

	public String getGugun_code() {
		return gugun_code;
	}

	public void setGugun_code(String gugun_code) {
		this.gugun_code = gugun_code;
	}

	public String getGugun_name() {
		return gugun_name;
	}

	public void setGugun_name(String gugun_name) {
		this.gugun_name = gugun_name;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}

	@Override
	public String toString() {
		return "HouseDealDto [sido_code=" + sido_code + ", sido_name=" + sido_name + ", gugun_code=" + gugun_code
				+ ", gugun_name=" + gugun_name + ", dong=" + dong + ", code=" + code + ", housename=" + housename + "]";
	}

}
