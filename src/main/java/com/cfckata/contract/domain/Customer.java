package com.cfckata.contract.domain;

import java.io.Serializable;

public class Customer implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
    private String name;
    private String idNumber;
    private String mobilePhone;

    public Customer(String id, String name, String idNumber, String mobilePhone) {
		super();
		this.id = id;
		this.name = name;
		this.idNumber = idNumber;
		this.mobilePhone = mobilePhone;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
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

}
