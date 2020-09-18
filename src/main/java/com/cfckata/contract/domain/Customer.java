package com.cfckata.contract.domain;

import com.cfckata.common.util.DateUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String ID_CARD_IS_EMPTY = "身份证号不能为空！";
	private static final String ILLEGAL_ID_CARD = "非法的身份证号：";
	private static final String ILLEGAL_ID_CARD_AFTER_THAN_NOW = "非法的身份证号，大于当前日期：";

	@NotBlank
	private String id;
	@NotBlank
    private String name;
	@NotBlank
	@Size(min=18,max=18)
    private String idNumber;
	@NotBlank
	@Size(min=11,max=11)
    private String mobilePhone;

    public Customer(String id, String name, String idNumber, String mobilePhone) {
		super();
		this.id = id;
		this.name = name;
		this.idNumber = idNumber;
		this.mobilePhone = mobilePhone;
	}

	public Customer() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public static int getAgeByIdCard(String idCard) {
		if(StringUtils.isEmpty(idCard)){
			throw new IllegalArgumentException(ID_CARD_IS_EMPTY);
		}
		int iAge = 0;

		Date bornDate = null;
		try {
			bornDate = DateUtil.FORMAT_NO_SEP_ON_DAY.parse(idCard.substring(6,14));
		} catch (ParseException e) {
			throw new IllegalArgumentException(ILLEGAL_ID_CARD+idCard);
		}

		Calendar bornCal = Calendar.getInstance();
		bornCal.setTime(bornDate);
		Calendar nowCal = Calendar.getInstance();

		if(bornCal.after(nowCal)){
			throw new IllegalArgumentException(ILLEGAL_ID_CARD_AFTER_THAN_NOW+idCard);
		}
		int age = nowCal.get(Calendar.YEAR) - bornCal.get(Calendar.YEAR);
		return (nowCal.get(Calendar.DAY_OF_YEAR) < bornCal.get(Calendar.DAY_OF_YEAR))?age-1:age;
	}
}
