package com.gs.checkrates.mas.util.validator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.gs.checkrates.mas.model.*;

public class CheckRatesValidator {
	
	public boolean validate (String input, String fields) throws Exception{
		
		Method method = null;
		try {
			method = this.getClass().getMethod("validate"+fields, String.class);
		
			return (boolean) method.invoke(this,input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean validateYearMonthDate(String str){

		if(str.matches("([0-9]{4})-([0-9]{2}) to ([0-9]{4})-([0-9]{2})")){
			String[] date = StringUtils.split(str," to ");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			sdf.setLenient(false);
			try {
				if(sdf.parse(date[1]).after(sdf.parse(date[0])) || sdf.parse(date[1]).equals(sdf.parse(date[0]))){
					return true;
				}else{
					return false;
				}
			} catch (ParseException e) {
				return false;
			}
		}else{
			return false;
		}

	}
	
	public boolean validateExit(String str){

		if("Y".equalsIgnoreCase(str)||"N".equalsIgnoreCase(str) ){
			return true;
		}else{
			return false;
		}

	}

}
