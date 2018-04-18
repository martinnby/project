package com.gs.checkrates.mas.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties({ "preliminary","fc_hire_purchase_motor_3y","fc_housing_loans_15y", "feeds_flatstore_entry_id","feeds_entity_id","resource_id","timestamp"})


public class MonthlyRates {
	
	@JsonCreator
	public MonthlyRates(
			@JsonProperty("end_of_month")String monthYear, 
			@JsonProperty("prime_lending_rate")String primeLendingRate, 
			@JsonProperty("banks_fixed_deposits_3m")String bankFd3, 
			@JsonProperty("banks_fixed_deposits_6m")String bankFd6, 
			@JsonProperty("banks_fixed_deposits_12m")String bankFd12,
			@JsonProperty("banks_savings_deposits")String bankSd, 
			@JsonProperty("fc_fixed_deposits_3m")String fcFd3,
			@JsonProperty("fc_fixed_deposits_6m")String fcFd6, 
			@JsonProperty("fc_fixed_deposits_12m")String fcFd12, 
			@JsonProperty("fc_savings_deposits")String fcSd) {
		super();
		this.monthYear = monthYear;
		this.primeLendingRate = trimToDash(primeLendingRate);
		this.bankFd3 = trimToDash(bankFd3);
		this.bankFd6 = trimToDash(bankFd6);
		this.bankFd12 = trimToDash(bankFd12);
		this.bankSd = trimToDash(bankSd);
		this.fcFd3 = trimToDash(fcFd3);
		this.fcFd6 = trimToDash(fcFd6);
		this.fcFd12 = trimToDash(fcFd12);
		this.fcSd = trimToDash(fcSd);
	}

	String trimToDash(String str){
		return str==null?"-":str;
	}
	
	@JsonProperty("end_of_month")
    private String monthYear;

	@JsonProperty("prime_lending_rate")
    private String primeLendingRate;

	@JsonProperty("banks_fixed_deposits_3m")
    private String bankFd3; 

	@JsonProperty("banks_fixed_deposits_6m")
    private String bankFd6;

	@JsonProperty("banks_fixed_deposits_12m")
    private String bankFd12;
    
	@JsonProperty("banks_savings_deposits")
    private String bankSd;

	@JsonProperty("fc_fixed_deposits_3m")
    private String fcFd3; 

	@JsonProperty("fc_fixed_deposits_6m")
    private String fcFd6;

	@JsonProperty("fc_fixed_deposits_12m")
    private String fcFd12;
    
	@JsonProperty("fc_savings_deposits")
    private String fcSd;
    




	public String getMonthYear() {
		return monthYear;
	}

	
	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}


	public String getPrimeLendingRate() {
		return primeLendingRate;
	}


	public void setPrimeLendingRate(String primeLendingRate) {
		this.primeLendingRate = primeLendingRate;
	}


	public String getBankFd3() {
		return bankFd3;
	}


	public void setBankFd3(String bankFd3) {
		this.bankFd3 = bankFd3;
	}


	public String getBankFd6() {
		return bankFd6;
	}


	public void setBankFd6(String bankFd6) {
		this.bankFd6 = bankFd6;
	}


	public String getBankFd12() {
		return bankFd12;
	}


	public void setBankFd12(String bankFd12) {
		this.bankFd12 = bankFd12;
	}


	public String getBankSd() {
		return bankSd;
	}


	public void setBankSd(String bankSd) {
		this.bankSd = bankSd;
	}


	public String getFcFd3() {
		return fcFd3;
	}


	public void setFcFd3(String fcFd3) {
		this.fcFd3 = fcFd3;
	}


	public String getFcFd6() {
		return fcFd6;
	}


	public void setFcFd6(String fcFd6) {
		this.fcFd6 = fcFd6;
	}


	public String getFcFd12() {
		return fcFd12;
	}




	public void setFcFd12(String fcFd12) {
		this.fcFd12 = fcFd12;
	}


	public String getFcSd() {
		return fcSd;
	}


	public void setFcSd(String fcSd) {
		this.fcSd = fcSd;
	}
	
	@Override
	public String toString() {
		return "MonthlyRates [monthYear=" + monthYear + ", primeLendingRate=" + primeLendingRate + ", bankFd3="
				+ bankFd3 + ", bankFd6=" + bankFd6 + ", bankFd12=" + bankFd12 + ", bankSd=" + bankSd + ", fcFd3="
				+ fcFd3 + ", fcFd6=" + fcFd6 + ", fcFd12=" + fcFd12 + ", fcSd=" + fcSd + "]";
	}

}