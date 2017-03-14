package com.xdailiao.entity;

import java.sql.Timestamp;

public class res_num_store {
	private Integer STORE_ID;
	private Integer PARENT_STORE_ID;
	private String STORE_NAME;
	private Integer STORE_TYPE;
	private String DEPART_SCORE;
	private String PROVINCE_CODE;
	private String AREA_CODE;
	private String COUNTY_CODE;
	private Timestamp EFFDATE;
	private Timestamp EXPDATE;
	private String OPER_DEPART_CODE;
	private String OPER_STAFF_NO;
	private Timestamp OPER_TIME;
	private String manager_name;
	private String manager_mobile;
	public Integer getSTORE_ID() {
		return STORE_ID;
	}
	public void setSTORE_ID(Integer sTORE_ID) {
		STORE_ID = sTORE_ID;
	}
	public Integer getPARENT_STORE_ID() {
		return PARENT_STORE_ID;
	}
	public void setPARENT_STORE_ID(Integer pARENT_STORE_ID) {
		PARENT_STORE_ID = pARENT_STORE_ID;
	}
	public String getSTORE_NAME() {
		return STORE_NAME;
	}
	public void setSTORE_NAME(String sTORE_NAME) {
		STORE_NAME = sTORE_NAME;
	}
	public Integer getSTORE_TYPE() {
		return STORE_TYPE;
	}
	public void setSTORE_TYPE(Integer sTORE_TYPE) {
		STORE_TYPE = sTORE_TYPE;
	}
	public String getDEPART_SCORE() {
		return DEPART_SCORE;
	}
	public void setDEPART_SCORE(String dEPART_SCORE) {
		DEPART_SCORE = dEPART_SCORE;
	}
	public String getPROVINCE_CODE() {
		return PROVINCE_CODE;
	}
	public void setPROVINCE_CODE(String pROVINCE_CODE) {
		PROVINCE_CODE = pROVINCE_CODE;
	}
	public String getAREA_CODE() {
		return AREA_CODE;
	}
	public void setAREA_CODE(String aREA_CODE) {
		AREA_CODE = aREA_CODE;
	}
	public String getCOUNTY_CODE() {
		return COUNTY_CODE;
	}
	public void setCOUNTY_CODE(String cOUNTY_CODE) {
		COUNTY_CODE = cOUNTY_CODE;
	}
	public Timestamp getEFFDATE() {
		return EFFDATE;
	}
	public void setEFFDATE(Timestamp eFFDATE) {
		EFFDATE = eFFDATE;
	}
	public Timestamp getEXPDATE() {
		return EXPDATE;
	}
	public void setEXPDATE(Timestamp eXPDATE) {
		EXPDATE = eXPDATE;
	}
	public String getOPER_DEPART_CODE() {
		return OPER_DEPART_CODE;
	}
	public void setOPER_DEPART_CODE(String oPER_DEPART_CODE) {
		OPER_DEPART_CODE = oPER_DEPART_CODE;
	}
	public String getOPER_STAFF_NO() {
		return OPER_STAFF_NO;
	}
	public void setOPER_STAFF_NO(String oPER_STAFF_NO) {
		OPER_STAFF_NO = oPER_STAFF_NO;
	}
	public Timestamp getOPER_TIME() {
		return OPER_TIME;
	}
	public void setOPER_TIME(Timestamp oPER_TIME) {
		OPER_TIME = oPER_TIME;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_mobile() {
		return manager_mobile;
	}
	public void setManager_mobile(String manager_mobile) {
		this.manager_mobile = manager_mobile;
	}
	
}
