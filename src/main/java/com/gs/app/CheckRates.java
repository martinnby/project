package com.gs.app;

import com.gs.checkrates.mas.controller.*;

public class CheckRates {

	public static void main(String[] args) {
		
		System.out.println("Welcome to CheckRates!\n");
		try {
			MASController mas = new MASController();
			mas.execute();
		} catch (Exception e) {
			System.out.println("System Error! Please try again later.");
			e.printStackTrace();
			System.exit(-1);
		}
		System.out.println("\n\nThanks for using CheckRates!\nPlease follow me on www.linkedin.com/in/martin-ng-55b43422");
		System.exit(0);
	}
}