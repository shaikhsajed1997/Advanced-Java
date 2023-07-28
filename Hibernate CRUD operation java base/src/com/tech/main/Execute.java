package com.tech.main;

import java.util.Scanner;

public class Execute {

	public static void main(String[] args) {

		Operation op = new Operation();
		Scanner sc = new Scanner(System.in);

		System.out.println("Select choice:\n1.savaData\n2.getAlldata\n3.updateData\n4.deleteData");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			String s=op.saveData();
			System.out.println(s);
			break;
		case 2:
			op.getAllData();
			break;
		case 3:
			op.updateData();
			break;
		case 4:
			op.daleteData();
			break;

		default:
			System.out.println("Please select correct choice");
			break;
		}

	}

}
