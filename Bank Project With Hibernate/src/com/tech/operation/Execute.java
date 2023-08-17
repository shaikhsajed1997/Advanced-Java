package com.tech.operation;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tech.entity.Account;
import com.tech.entity.Account_Info;
import com.tech.util.HibernateUtil;

public class Execute {

	Account ac = new Account();
	Account_Info aci = new Account_Info();
	Scanner sc = new Scanner(System.in);
	SessionFactory sf = HibernateUtil.getSessionFactory();

	// this method is to verify or check your account number is availble in bank or
	// not
	public void accountVerification() {
		Session sn = sf.openSession();

		System.out.println("Enter Aadhar Number:");
		long aadharNo = sc.nextLong();

		Account_Info ac_info = sn.get(Account_Info.class, aadharNo);

		if (ac_info != null) {

			System.out.println(ac_info.getAccountNumber());
			System.out.println(ac_info.getAadharNumber());
			System.out.println(ac_info.getAccountName());
			sn.close();
			sf.close();
		} else {
			System.out.println("You not create account, please create account");
		}

	}

	// in this method new account will be created
	public void createAccount() {

		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();

		try {
			System.out.println("Please select account type:\n1.Saving Account \n2.Current Account");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				ac.setAccountType("Saving Account");
				break;
			case 2:
				ac.setAccountType("Current Account");
			default:
				System.out.println("Please select correct choice");
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Enter choice should be in Integer");
		}
		
		System.out.println("Enter account number:");
		long accNo = sc.nextLong();		
		ac.setAccountNumber(accNo);
		aci.setAccountNumber(accNo);
		

		System.out.println("Account Holder Name:");
		System.out.println("First Name:");
		String firstName = sc.next();
		System.out.println("Last Name:");
		String lastName = sc.next();
		ac.setAccountName(firstName + " " + lastName);

		aci.setAccountName(firstName + " " + lastName);

		while (true) {
			System.out.println("Account Holder Aadhar Number:");
			long aadhar = sc.nextLong();
			if (aadhar >= 100000 && aadhar <= 999999) {
				ac.setAadharNumber(aadhar);
				aci.setAadharNumber(aadhar);
				break;
			} else {
				System.out.println("please enter 6 digit number ");
			}
		}

		System.out.println("Account Holder Mobile Number:");
		ac.setMobileNumber(sc.next());

		System.out.println("Account Holder Email Id:");
		ac.setEmailId(sc.next());

		while (true) {
			try {
				System.out.println("Deposit Amount:");
				double amt = sc.nextDouble();
				if (amt >= 500) {
					ac.setDepositMoney(amt);
					break;

				} else {
					System.out.println("Deposit  amount must greter than or equal to 500");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter amount in Integer value");
			}
		}

		// Account creation date and time
		ac.setDate(new Date());

		System.out.println("Set Username:");
		ac.setUserName(sc.next());

		System.out.println("Set Password:");
		ac.setPassword(sc.next());

		sn.save(ac);
		sn.save(aci);
		tr.commit();
		System.out.println("Account created successfuly");

		sn.close();
		sf.close();

	}

	// in this method we can access our account details
	public void showAccountDetails() {

		Session sn = sf.openSession();

		while (true) {

			System.out.println("Enter Your Aadhar Number:");
			long acc = sc.nextLong();

			Account ac1 = sn.get(Account.class, acc);
			if (ac1 != null) {
				System.out.println("Account Number: " + ac1.getAccountNumber());
				System.out.println("Account type: " + ac1.getAccountType());
				System.out.println("Account Holder name: " + ac1.getAccountName());
				System.out.println("Account Holder Aadhar Number: " + ac1.getAadharNumber());
				System.out.println("Account Holder Mobile number: " + ac1.getMobileNumber());
				System.out.println("Account Holder Email Id: " + ac1.getEmailId());
				System.out.println("Total Balance: " + ac1.getDepositMoney());
				System.out.println("Account userName: " + ac1.getUserName());
				System.out.println("Account password: " + ac1.getPassword());
				sn.close();
				sf.close();
				break;
			} else {
				System.out.println("You have not created account,please create account");
			}

		}

	}

	// In this method we can add or deposit money in our bank account
	public void depositMoney() {
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		System.out.println("Enter Your Aadhar  Number:");
		long acc = sc.nextLong();
		Account ac1 = sn.get(Account.class, acc);
		if (ac1 != null) {
			double y = ac1.getDepositMoney();
			Query<Account> hql = sn.createQuery("update Account set depositMoney=:amount where aadharNumber=:accno");
			System.out.println("Enter Deposit Amount:");
			double x = sc.nextDouble();
			hql.setParameter("amount", y + x);
			hql.setParameter("accno", acc);
			int p = hql.executeUpdate();
			if (p != 0) {
				tr.commit();

				System.out.println("Amount deposit in your account successfuly");

				System.out.println("Total Account Balance: " + (y + x));

				sn.close();
				sf.close();
			} else {
				System.out.println("Record not found");
			}

		} else {
			System.out.println("You have not create account and please create account");
		}
	}

//By usin this method we can check total avilable balance amount in our bank account
	public void balanceCheck() {
		Session sn = sf.openSession();
		System.out.println("Enter your Aadhar number:");
		long acc = sc.nextLong();

		Account ac1 = sn.get(Account.class, acc);

		if (ac1 != null) {
			System.out.println("Total Balance Amount:");
			System.out.println(ac1.getDepositMoney());
			sn.close();
			sf.close();
		} else {
			System.out.println("Yon have not create account");
		}
	}

// By using this method we can withdraw amount from our bank account
	public void withdrawMoney() {

		Session sn = sf.openSession();
		Transaction t = sn.beginTransaction();
		System.out.println("Enter your Aadhar number:");
		long acc = sc.nextLong();
		Account ac1 = sn.get(Account.class, acc);

		if (ac1 != null) {
			System.out.println("Total Balance in your Account: " + ac1.getDepositMoney());
			System.out.println("Enter your withdraw Amount:");
			double amount = sc.nextDouble();
			if (amount > 0) {
				double total = ac1.getDepositMoney() - amount;
				if (total >= 500) {
					Query<Account> hql = sn
							.createQuery("update Account set depositMoney=:amount where aadharNumber=:accno");
					hql.setParameter("amount", total);
					hql.setParameter("accno", acc);
					int h = hql.executeUpdate();
					if (h != 0) {

						t.commit();
						System.out.println(amount + " Amount withdraw success");
						sn.close();
						sf.close();
					} else {
						System.out.println("Record not found");
					}

				} else {
					System.out.println("You can't withdraw because your account balance is less than 500");
				}
			} else {
				System.out.println("please enter valid amount");
			}
		} else {
			System.out.println("Please create account ");
		}
	}

	// By using this method we can transfer money from one account to another
	// account
	public void transferMoney() {

		Session sn = sf.openSession();
		Transaction t = sn.beginTransaction();

		System.out.println("Enter Aadhar Number for TransferMoney:");
		long acc1 = sc.nextLong();
		Account ac1 = sn.get(Account.class, acc1);
		if (ac1 != null) {
			System.out.println("Enter Aadhar number from TransferMoney:");
			long acc2 = sc.nextLong();
			Account ac2 = sn.get(Account.class, acc2);
			if (ac2 != null) {
				System.out.println("Total Balance in your Account: " + ac2.getDepositMoney());
				System.out.println("Enter Amount for Transfer:");
				double sendMoney = sc.nextDouble();
				if (sendMoney > 0) {
					// for account from money debited
					double total = ac2.getDepositMoney() - sendMoney;
					if (total >= 500) {
						Query<Account> hql1 = sn
								.createQuery("update Account set depositMoney=:amount where aadharNumber=:accno");
						hql1.setParameter("amount", total);
						hql1.setParameter("accno", acc2);
						int x = hql1.executeUpdate();

						// for account where money credited
						double balance = ac1.getDepositMoney() + sendMoney;
						Query<Account> hql2 = sn
								.createQuery("update Account set depositMoney=:amount where aadharNumber=:accno");
						hql2.setParameter("amount", balance);
						hql2.setParameter("accno", acc1);
						int y = hql2.executeUpdate();
						if (x != 0 && y != 0) {
							t.commit();
							sn.close();
							sf.close();
							System.out.println(sendMoney + " Amount transfer Successful");
						} else {
							System.out.println("Given account number record not found");
						}
					} else {
						System.out.println("You can't transfer money because your account balance is less than 500");
					}
				} else {
					System.out.println("Amount should be greater than zero");
				}
			} else {
				System.out.println("You have not created account");
			}

		} else {
			System.out.println("You have not created account.");
		}

	}

}
