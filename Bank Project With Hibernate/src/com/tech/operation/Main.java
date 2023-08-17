package com.tech.operation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		
			Execute ex = new Execute();
			Scanner sc = new Scanner(System.in);

			System.out.println("Select Operation:\n1.accountVerification\n2.createAccount\n3.showAccount"
					+ "\n4.depositMoney\n5.balanceCheck\n6.withdrawMoney\n7.TranferMoney"
					);
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				ex.accountVerification();
				break;
			case 2:
				ex.createAccount();
				break;
			case 3:
				ex.showAccountDetails();
				break;
			case 4:
				ex.depositMoney();
				break;

			case 5:
				ex.balanceCheck();
				break;

			case 6:
				ex.withdrawMoney();
				break;
				
			case 7:
				ex.transferMoney();
				break;

			default:
				System.out.println("Please select correct choice");
				break;
			}

		
	}

}
