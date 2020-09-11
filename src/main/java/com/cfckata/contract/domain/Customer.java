package com.cfckata.contract.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {
    private String id;
    private String name;
    private String idNumber;
    private String mobilePhone;

    public Customer() {
    }
}
