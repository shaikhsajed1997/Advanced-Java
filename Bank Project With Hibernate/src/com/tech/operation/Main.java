package com.tech.operation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Execute ex= new Execute();
		Scanner sc=new Scanner(System.in);
	
		System.out.println("Select Operation:\n1.createAccount\n2.showAccount"
				+ "\n3.depositMoney\n4.balanceCheck\n5.withdrawMoney\n6.TranferMoney");
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			ex.createAccount();
			break;
		case 2:
			ex.showAccountDetails();
			break;
		case 3:
			ex.depositMoney();
			break;
			
		case 4:
			ex.balanceCheck();
			break;
		case 5:
			ex.withdrawMoney();
			break;
		case 6:
			ex.transferMoney();
			break;
			
		default:
			System.out.println("Please select correct choice");
			break;
		}

	}
	

}
