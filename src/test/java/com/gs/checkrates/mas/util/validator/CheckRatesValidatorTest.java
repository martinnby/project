package com.gs.checkrates.mas.util.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckRatesValidatorTest {

	@Test
	public void testValidateYearMonthDate() {
		CheckRatesValidator val = new CheckRatesValidator();
		
		assertTrue(val.validateYearMonthDate("2012-11 to 2012-12"));
	}

	@Test
	public void testValidateYearMonthDateRange() {
		CheckRatesValidator val = new CheckRatesValidator();
		
		assertTrue(val.validateYearMonthDate("2012-11 to 2012-12"));
	}
	

	@Test
	public void testValidateYearMonthDateRangeEqual() {
		CheckRatesValidator val = new CheckRatesValidator();
		
		assertTrue(val.validateYearMonthDate("2012-11 to 2012-11"));
	}
	
	@Test
	public void testValidateYearMonthDateDateRangeInvalid() {
		CheckRatesValidator val = new CheckRatesValidator();
		
		assertFalse(val.validateYearMonthDate("2012-12 to 2012-11"));
	}
	
	@Test
	public void testValidateYearMonthDateInvalid13Mth() {
		CheckRatesValidator val = new CheckRatesValidator();
		
		assertFalse(val.validateYearMonthDate("2012-12 to 2012-13"));
	}
	@Test
	public void testValidateYearMonthDateInvalid0Mth() {
		CheckRatesValidator val = new CheckRatesValidator();
	
		assertFalse(val.validateYearMonthDate("2012-0 to 2012-0"));
	}
	
	@Test
	public void testValidateYearMonthDateInvalid00Mth() {
		CheckRatesValidator val = new CheckRatesValidator();
	
		assertFalse(val.validateYearMonthDate("2012-00 to 2012-01"));
	}
	@Test
	public void testValidateYearMonthDateNonCompatDateFormat1() {
		CheckRatesValidator val = new CheckRatesValidator();
		
		assertFalse(val.validateYearMonthDate("2012/12"));
	}
	@Test
	public void testValidateYearMonthDateNonCompatDateFormat2() {
		CheckRatesValidator val = new CheckRatesValidator();
		
		assertFalse(val.validateYearMonthDate("2012-Jan"));
	}
	@Test
	public void testValidateYearMonthDateNonCompatDateFormat3() {
		CheckRatesValidator val = new CheckRatesValidator();
		
		assertFalse(val.validateYearMonthDate("2012/Jan"));
	}
	
	@Test
	public void testValidateYearMonthDateFieldFromMethodInvoker() throws Exception {
		CheckRatesValidator val = new CheckRatesValidator();
		
		assertTrue(val.validate ("2012-11 to 2012-12", "YearMonthDate"));
	}
	@Test
	public void testValidateExitFieldMethodInvoker() throws Exception {
		CheckRatesValidator val = new CheckRatesValidator();
		
		assertTrue(val.validate ("Y", "Exit"));
	}
	
	@Test
	public void testValidateYearMonthDateFieldFromMethodInvokerInvalid() throws Exception {
		CheckRatesValidator val = new CheckRatesValidator();
		
		assertFalse(val.validate ("2012-13", "YearMonthDate"));
	}
	@Test
	public void testValidateExitFieldMethodInvokerInvalid() throws Exception {
		CheckRatesValidator val = new CheckRatesValidator();
		
		assertFalse(val.validate ("V", "Exit"));
	}
	
	
}
