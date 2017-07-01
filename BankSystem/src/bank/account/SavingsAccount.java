/**
 * The class SavingsAccount is sub class of class Account.
 */
package bank.account;
import bank.account.exceptions.*;
/**
 * 
 * @author sangeetha
 *
 */
public class SavingsAccount extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = 416734214109577626L;

	private float interest = 6;
	private double minBal = 500;
	private int lastMonth = 0;
	private int lastYear = 0;

	/**
	 * constructor
	 * @param accNumber
	 * @param money
	 * @throws InvalidDepositAmountException
	 */
	SavingsAccount(String accNumber, double money)
			throws InvalidDepositAmountException {
		super(accNumber);
		if (money >= 1000) {
			amount = money;
		} else {
			throw new InvalidDepositAmountException(
					"Deposit money should be greater than 1000.");
		}
	}

	/**
	 * withdraw money
	 */
	public void withdraw(double money) throws InvalidWithdrawAmountException {
		if (money <= (amount - minBal)) {
			amount -= money;
		} else {
			throw new InvalidWithdrawAmountException("Insufficient balance in the account.");
		}

	}

	/**
	 * set overdraft
	 */
	public void setOverdraft(int od) throws InvalidOverdraftLimitException {
		throw new InvalidOverdraftLimitException("Can not change overdraft limit in the Current account.");
	}

	/**
	 * getType() function returns true or false value.
	 * This function is helpful in main() for checking for Savings or Current account
	 * Implementing the concept of polymorphism.
	 */
	public boolean getType() {
		return false;
	}

	/**
	 * addInterest() function takes two parameters, which are current month and current year
	 - It is used for adding interest to the account.
	 - As per company rules, one(manager) can not add interest 
	 - On the first time, while opening an account, the date on which 
	 account created is entered.
	 - Here the base of month is 12. therefore we can  write in a single number.
	 which is month+(year*12). 
	 
	 Logic:
	 - If the passed month and year are greater than previous transaction and 
	 less than (previous transaction-4), then the interest will be added, and returns true.
	 - Otherwise, it will return false.	 
	 - Here, interest is counted using the formula I=P*R*N/100. 
	 -  After adding money to account, it will increment the last month by 4.
	 but, the base of month is 12. Hence, if month exceeds 12 then we need to increase 
	 year by 1. and reduce the value of month by 1.
	 */
	public boolean addInterest(int month, int year) {
		if ((lastMonth + lastYear * 12) < (month + year * 12)
				&& (lastMonth + lastYear * 12 + 3) >= (month + year * 12)) {
			amount += (amount * interest * 0.25 / 100);
			lastMonth += 3;
			if (lastMonth >= 12) {
				lastMonth -= 12;
				lastYear += 1;
			}
			return true;
		}

		return false;
	}


	/**
	 * setDate() function is used for setting default date for the first time of adding interest.
	 * - It stores the date creation time in lastMonth and lastYear.
	 * Logic:
	 * It has two parameters which are int. 
	 * It saves the value as start of quarter.if month is from 1 to 3, then it will save 0% interest.
	 * if 4 to 6,then it will save 3% interest
	 * similarly, 7 to 9 will save 6% interest and 10 to 12 it will save 9% interest
	 - Year will remain same.
	 - It can be implemented in main as well.
	 */
	public void setDate(int month, int year) {
		int i;
		for (i = 0; i < 4; i++) {
			if ((month > i * 3) && (month <= 3 * (i + 1)))
				month = i * 3;
		}
		lastMonth = month;
		lastYear = year;
	}
	
	/**
	 * setInterest() function has float parameter for setting it's 
	 * value as interest rate. It is used when Bank changes it's
	 * interest rate.
	 */
	public void setInterest(float rate) {
		if (rate > 0) {
			interest = rate;
		} else {
			throw new InvalidInterestRateException(" The interest must be positive.");
		}
	}
}
