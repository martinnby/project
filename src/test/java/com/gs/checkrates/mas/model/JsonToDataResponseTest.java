package com.gs.checkrates.mas.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonToDataResponseTest {

   @Test
   public void givenFullJson_Deserialize_thenSuccess() throws Exception{
     
	   String testJsonFullContext="{\"help\":\"Search a datastore table. :param resource_id: id or alias of the data that is going to be selected.\",\"success\":true,\"result\":{\"fields\":[{\"id\":\"end_of_month\",\"type\":\"text\"},{\"id\":\"preliminary\",\"type\":\"text\"},{\"id\":\"prime_lending_rate\",\"type\":\"float\"},{\"id\":\"banks_fixed_deposits_3m\",\"type\":\"float\"},{\"id\":\"banks_fixed_deposits_6m\",\"type\":\"float\"},{\"id\":\"banks_fixed_deposits_12m\",\"type\":\"float\"},{\"id\":\"banks_savings_deposits\",\"type\":\"float\"},{\"id\":\"fc_hire_purchase_motor_3y\",\"type\":\"float\"},{\"id\":\"fc_housing_loans_15y\",\"type\":\"float\"},{\"id\":\"fc_fixed_deposits_3m\",\"type\":\"float\"},{\"id\":\"fc_fixed_deposits_6m\",\"type\":\"float\"},{\"id\":\"fc_fixed_deposits_12m\",\"type\":\"float\"},{\"id\":\"fc_savings_deposits\",\"type\":\"float\"}],\"resource_id\":[\"5f2b18a8-0883-4769-a635-879c63d3caac\"],\"limit\":1,\"total\":\"423\",\"records\":[{\"end_of_month\":\"1983-01\",\"preliminary\":null,\"prime_lending_rate\":\"9.53\",\"banks_fixed_deposits_3m\":\"6.75\",\"banks_fixed_deposits_6m\":\"6.80\",\"banks_fixed_deposits_12m\":\"7.13\",\"banks_savings_deposits\":\"6.50\",\"fc_hire_purchase_motor_3y\":\"12.67\",\"fc_housing_loans_15y\":\"12.42\",\"fc_fixed_deposits_3m\":\"7.15\",\"fc_fixed_deposits_6m\":\"7.30\",\"fc_fixed_deposits_12m\":\"7.70\",\"fc_savings_deposits\":\"7.21\",\"feeds_flatstore_entry_id\":\"59474\",\"timestamp\":\"1522721699\",\"feeds_entity_id\":null}]}}";

	    ObjectMapper mapper = new ObjectMapper();
       mapper.reader().forType(Response.class).readValue(testJsonFullContext);
   }

   
   @Test
   public void givenEmptyRecordsJson_Deserialize_thenSuccess() throws Exception{
     
	   String testJsonFullContext="{\"help\":\"Search a datastore table. :param resource_id: id or alias of the data that is going to be selected.\",\"success\":true,\"result\":{\"fields\":[{\"id\":\"end_of_month\",\"type\":\"text\"},{\"id\":\"preliminary\",\"type\":\"text\"},{\"id\":\"prime_lending_rate\",\"type\":\"float\"},{\"id\":\"banks_fixed_deposits_3m\",\"type\":\"float\"},{\"id\":\"banks_fixed_deposits_6m\",\"type\":\"float\"},{\"id\":\"banks_fixed_deposits_12m\",\"type\":\"float\"},{\"id\":\"banks_savings_deposits\",\"type\":\"float\"},{\"id\":\"fc_hire_purchase_motor_3y\",\"type\":\"float\"},{\"id\":\"fc_housing_loans_15y\",\"type\":\"float\"},{\"id\":\"fc_fixed_deposits_3m\",\"type\":\"float\"},{\"id\":\"fc_fixed_deposits_6m\",\"type\":\"float\"},{\"id\":\"fc_fixed_deposits_12m\",\"type\":\"float\"},{\"id\":\"fc_savings_deposits\",\"type\":\"float\"}],\"resource_id\":[\"5f2b18a8-0883-4769-a635-879c63d3caac\"],\"limit\":1,\"total\":\"423\",\"records\":[]}}";

	    ObjectMapper mapper = new ObjectMapper();
       mapper.reader().forType(Response.class).readValue(testJsonFullContext);
   }
   
   
   @Test
   public void given1ArrayRecordsCheck_Deserialize_thenSuccess() throws Exception{
     
	   String testJsonFullContext="{\"help\":\"Search a datastore table. :param resource_id: id or alias of the data that is going to be selected.\",\"success\":true,\"result\":{\"fields\":[{\"id\":\"end_of_month\",\"type\":\"text\"},{\"id\":\"preliminary\",\"type\":\"text\"},{\"id\":\"prime_lending_rate\",\"type\":\"float\"},{\"id\":\"banks_fixed_deposits_3m\",\"type\":\"float\"},{\"id\":\"banks_fixed_deposits_6m\",\"type\":\"float\"},{\"id\":\"banks_fixed_deposits_12m\",\"type\":\"float\"},{\"id\":\"banks_savings_deposits\",\"type\":\"float\"},{\"id\":\"fc_hire_purchase_motor_3y\",\"type\":\"float\"},{\"id\":\"fc_housing_loans_15y\",\"type\":\"float\"},{\"id\":\"fc_fixed_deposits_3m\",\"type\":\"float\"},{\"id\":\"fc_fixed_deposits_6m\",\"type\":\"float\"},{\"id\":\"fc_fixed_deposits_12m\",\"type\":\"float\"},{\"id\":\"fc_savings_deposits\",\"type\":\"float\"}],\"resource_id\":[\"5f2b18a8-0883-4769-a635-879c63d3caac\"],\"limit\":1,\"total\":\"423\",\"records\":[{\"end_of_month\":\"1983-01\",\"preliminary\":null,\"prime_lending_rate\":\"9.53\",\"banks_fixed_deposits_3m\":\"6.75\",\"banks_fixed_deposits_6m\":\"6.80\",\"banks_fixed_deposits_12m\":\"7.13\",\"banks_savings_deposits\":\"6.50\",\"fc_hire_purchase_motor_3y\":\"12.67\",\"fc_housing_loans_15y\":\"12.42\",\"fc_fixed_deposits_3m\":\"7.15\",\"fc_fixed_deposits_6m\":\"7.30\",\"fc_fixed_deposits_12m\":\"7.70\",\"fc_savings_deposits\":\"7.21\",\"feeds_flatstore_entry_id\":\"59474\",\"timestamp\":\"1522721699\",\"feeds_entity_id\":null}]}}";

	    ObjectMapper mapper = new ObjectMapper();
	    Response test = mapper.reader().forType(Response.class).readValue(testJsonFullContext);
	    assertTrue(test.getResult().getRecords().size()==1);
    
   }
   
   @Test
   public void givenFieldsCheck_Deserialize_thenSuccess() throws Exception{
     
	   
	   String success = "true";
	   String limit = "1";
	   
	   String monthYear = "2017-01";
	   String primeLendingRate = "10";
	   String bankFd3 = "2";
	   String bankFd6 = "3";
	   String bankFd12 = "4";
	   String bankSd = "5";
	   String fcFd3 = "6";
	   String fcFd6 = "7";
	   String fcFd12 = "8";
	   String fcSd = "9";
		
	   
	   String testFieldsJson="{\"success\":"+success+
			   ",\"result\":{\"limit\":"+ limit +
			   ",\"records\":[{\"end_of_month\":\""+monthYear+
			   "\",\"prime_lending_rate\":\""+primeLendingRate+ 
			   "\",\"banks_fixed_deposits_3m\":\""+bankFd3+
			   "\",\"banks_fixed_deposits_6m\":\""+bankFd6+
			   "\",\"banks_fixed_deposits_12m\":\""+bankFd12+
			   "\",\"banks_savings_deposits\":\""+bankSd+
			   "\",\"fc_fixed_deposits_3m\":\""+fcFd3+
			   "\",\"fc_fixed_deposits_6m\":\""+fcFd6+
			   "\",\"fc_fixed_deposits_12m\":\""+fcFd12+
			   "\",\"fc_savings_deposits\":\""+fcSd+
			   "\"}]}}";
 
	   ObjectMapper mapper = new ObjectMapper();
	   Response target = mapper.reader().forType(Response.class).readValue(testFieldsJson);
	    
	    assertTrue(success.equals(target.getSuccess()) && 
	    		limit.equals(target.getResult().getLimit())&&
	    		monthYear.equals(target.getResult().getRecords().get(0).getMonthYear())&&
	    		primeLendingRate.equals(target.getResult().getRecords().get(0).getPrimeLendingRate())&&
	    		bankFd3.equals(target.getResult().getRecords().get(0).getBankFd3())&&
	    		bankFd6.equals(target.getResult().getRecords().get(0).getBankFd6())&&
	    		bankFd12.equals(target.getResult().getRecords().get(0).getBankFd12())&&
	    		bankSd.equals(target.getResult().getRecords().get(0).getBankSd())&&
	    		fcFd3.equals(target.getResult().getRecords().get(0).getFcFd3())&&
	    		fcFd6.equals(target.getResult().getRecords().get(0).getFcFd6())&&
	    		fcFd12.equals(target.getResult().getRecords().get(0).getFcFd12())&&
	    		fcSd.equals(target.getResult().getRecords().get(0).getFcSd())
	    		);
	    
   }
   
}
