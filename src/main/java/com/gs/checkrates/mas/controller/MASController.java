package com.gs.checkrates.mas.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.ListUI;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gs.checkrates.mas.model.*;
import com.gs.checkrates.mas.service.MASManager;
import com.gs.checkrates.mas.util.validator.CheckRatesValidator;

public class MASController {

	public void execute() throws Exception{

		String input="Y";
		
		while(input.equals("Y")){
			
			
			//Step 1: Validate the result YYYY-MM to YYYY-MM
			input = screenOutWithInputValidation("\nPlease enter the date period to check the interest rates (<YYYY-MM> to <YYYY-MM>, e.g. 2017-02 to 2017-03): ","YearMonthDate");
			
			//Step 2: Call MAS
			screenOut("Retrieving data...");
			MASManager masmgr = new MASManager();
			Response res = masmgr.checkMonthlyRates(input);
			
			//Step3: Format the result
			res.getResult().getRecords();
		
			StringBuffer bufferPLR = new StringBuffer(); 
			StringBuffer bufferfd3 = new StringBuffer(); 
			StringBuffer bufferfd6 = new StringBuffer(); 
			StringBuffer bufferfd12 = new StringBuffer(); 
			StringBuffer bufferSd = new StringBuffer(); 
			
			
			//TO-DO - this should a common handler to print the records from map record with the fields and fields ID from Web API 
			if(res.getResult().getRecords()!=null && res.getResult().getRecords().size()>0){

				bufferfd3.append("Fixed Deposits 3 Months: "+"\n");
				bufferfd3.append(header());

				bufferfd6.append("Fixed Deposits 6 Months: "+"\n");
				bufferfd6.append(header());
			
				bufferfd12.append("Fixed Deposits 12 Months: "+"\n");
				bufferfd12.append(header());
				
				bufferSd.append("Fixed Deposits 12 Months: "+"\n");
				bufferSd.append(header());
				
				List aveFc3 = new ArrayList();
				List aveFc6 = new ArrayList();
				List aveFc12 = new ArrayList();
				List aveFcSd = new ArrayList();

				List aveBk3 = new ArrayList();
				List aveBk6 = new ArrayList();
				List aveBk12 = new ArrayList();
				List aveBkSd = new ArrayList();
				
				
				for (MonthlyRates record : res.getResult().getRecords()) {
					
					bufferfd3.append(data(record.getMonthYear(),record.getFcFd3(),record.getBankFd3()));
					bufferfd6.append(data(record.getMonthYear(),record.getFcFd6(),record.getBankFd6()));
					bufferfd12.append(data(record.getMonthYear(),record.getFcFd12(),record.getBankFd12()));
					bufferSd.append(data(record.getMonthYear(),record.getFcSd(),record.getBankSd()));
					
					if(!"-".equals(record.getFcFd3())&&!"-".equals(record.getBankFd3())) {
						aveFc3.add(record.getFcFd3());
						aveBk3.add(record.getBankFd3());
					}
					if(!"-".equals(record.getFcFd6())&&!"-".equals(record.getBankFd6())) {
						aveFc6.add(record.getFcFd6());
						aveBk6.add(record.getBankFd6());
					}
					if(!"-".equals(record.getFcFd12())&&!"-".equals(record.getBankFd12())) {
						aveFc12.add(record.getFcFd12());
						aveBk12.add(record.getBankFd12());
					}
					if(!"-".equals(record.getFcSd())&&!"-".equals(record.getBankSd())) {
						aveFcSd.add(record.getFcSd());
						aveBkSd.add(record.getBankSd());
					}
					
				}
				
				
				bufferfd3.append(data("AVERAGE",mean( aveFc3.toArray()) ,mean( aveBk3.toArray())));
				bufferfd6.append(data("AVERAGE",mean(aveFc6.toArray()) ,mean(aveBk6.toArray())));
				bufferfd12.append(data("AVERAGE",mean(aveFc12.toArray()) ,mean(aveBk12.toArray())));
				bufferSd.append(data("AVERAGE",mean( aveFcSd.toArray()) ,mean( aveBkSd.toArray())));
				
				
				bufferfd3.append(dataStr("TREND",trending( aveFc3.toArray()) ,trending( aveBk3.toArray())));
				bufferfd6.append(dataStr("TREND",trending(aveFc6.toArray()) ,trending(aveBk6.toArray())));
				bufferfd12.append(dataStr("TREND",trending(aveFc12.toArray()) ,trending(aveBk12.toArray())));
				bufferSd.append(dataStr("TREND",trending( aveFcSd.toArray()) ,trending( aveBkSd.toArray())));
			
				screenOut("\n\nInterest Rates tables from "+input+".");
				screenOut("Remarks:");
				screenOut("1. * denotes Financial Companies(FC) rates is higher than Banks (Banks) rate. ");
				screenOut("2. - denotes no record found for that month.");
				screenOut("3. AVERAGE denotes average interest for the found records.");
				screenOut("4. TREND denotes upward or downward for the found records.");
				screenOut("5. Figures refer to average rates quoted by 10 leading banks and finance companies.");
				screenOut(bufferPLR.toString()+"\n\n"+bufferfd3+"\n\n"+bufferfd6+"\n\n"+bufferfd12+"\n\n"+bufferSd);
				
				
			}else{
				screenOut("No record found!");
			}
			
			//Last Step
			//Continue next cycle of work flow
			input = screenOutWithInputValidation("\nY to continue, N to exit: ","Exit");
		}
	}
	
	private String mean(Object[] m) {
	    double sum = 0;
	    for (int i = 0; i < m.length; i++) {
	        sum += Double.valueOf((String)m[i]).doubleValue();
	    }
	    DecimalFormat df2 = new DecimalFormat("###.##");

	    return df2.format(sum / m.length);
	}
	
	private String trending(Object[] m) {
		if( Double.valueOf((String)m[0]).doubleValue()<Double.valueOf((String)m[m.length-1]).doubleValue()){
			return "Upward";
		}else{
			return "Downward";
		}
	}

	
	private String data(String date,String fcFields, String bkFields){
		
		String higherRates = "";
		if(!"-".equals(fcFields) && !"-".equals(bkFields)){
			higherRates = Double.valueOf(fcFields).doubleValue() > Double.valueOf(bkFields).doubleValue()? "*":"";  
		}
	 	return StringUtils.rightPad(date,"YYYY-MM".length())+"|" +StringUtils.rightPad(fcFields+ higherRates,"Banks Rates".length())+"|" +StringUtils.rightPad(bkFields,"Banks Rates".length())+"\n" ; 
	
	}
	
	private String dataStr(String date,String fcFields, String bkFields){
		
		String higherRates = "";
		return StringUtils.rightPad(date,"YYYY-MM".length())+"|" +StringUtils.rightPad(fcFields+ higherRates,"Banks Rates".length())+"|" +StringUtils.rightPad(bkFields,"Banks Rates".length())+"\n" ; 
	
	}

	private String header(){
		return StringUtils.rightPad("YYYY-MM","YYYY-MM".length())+"|" +StringUtils.rightPad("FC Rates","Banks rates".length())+"|" +StringUtils.rightPad("Banks Rates","Banks Rates".length())+"\n"+  
		 	   StringUtils.rightPad("=","YYYY-MM".length(),"=")+"|" +StringUtils.rightPad("=","Banks rates".length(),"=")+"|" +StringUtils.rightPad("=","Banks Rates".length(),"=")+"\n" ; 

	}

	 // Create a single shared Scanner for keyboard input
	private static Scanner scanner = new Scanner( System.in );
   
	public void screenOut(String str){
		System.out.println( str );
	}
	
	private String screenOutWithInput(String str){
		System.out.print( str );
		 // Prompt the user
		String input = scanner.nextLine();
		return input;
	}
	
	private String screenOutWithInputValidation(String str,String fields) throws Exception{
		String input = "";
		while (true){
			input  = screenOutWithInput(str);
			CheckRatesValidator validatior = new CheckRatesValidator();
			if(validatior.validate(input,fields)){
				break;
			}
			screenOut("You have enter a wrong value!");
		}
		return input;
	}

}
