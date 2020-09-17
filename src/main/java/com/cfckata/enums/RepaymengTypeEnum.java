package com.cfckata.enums;

public enum RepaymengTypeEnum {
	DEBJ("DEBJ","等额本金"),
	DEBX("DEBX","等额本息"),
	;
	private final String code;
	private final String desc;
	
	private RepaymengTypeEnum(String code,String desc) {
		this.code = code;
		this.desc = desc;
	}
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
}

