/**
 * Account Class
 * We cannot create an object (account) without
 * Specifying it's type which are Savings and Current.
 * Hence, class account is abstract
 * 
 */
package bank.account;
import java.io.Serializable;

import bank.account.exceptions.InvalidAccountNumberException;
import bank.account.exceptions.InvalidDepositAmountException;
/**
 * 
 * @author sangeetha
 *
 */
public abstract class Account implements Serializable
{    
	/**
	 * 
	 */
	private static final long serialVersionUID = -799127150730292614L;
	
    private String accountNo;
    protected double amount = 0;
    
    /**
     * Parameterized Account Constructor
     * @param number
     * @throws InvalidAccountNumberException
     */
    Account(String number) throws InvalidAccountNumberException     
	{
		if (number.length() == 0) {
			throw new InvalidAccountNumberException("The Account number cannot be null,Please enter correct 'account no'");
		}
		accountNo = number;
	}

   /**
    * Get Amount
    * @return
    */
    public double getAmount()
    {
        return amount;
    }
    
    /**
     * Get Account Number
     * @return
     */
    public String getAccountNumber()
    {
        return accountNo;
    }
    
    /**
     * Deposit Amount
     * @param money
     * @throws InvalidDepositAmountException
     */
    public void deposited(double money) throws InvalidDepositAmountException
    {
		if (money > 0) {
			amount += money;
		} else {
			throw new InvalidDepositAmountException("The Deposited amount is invalid one.");
		}
    }
    
    /**
     * 
     * @param rate
     */
    public abstract void setInterest(float rate);
    /**
     * 
     * @param month
     * @param year
     * @return
     */
    public abstract boolean addInterest(int month , int year);    
    /**
     * 
     * @param month
     * @param year
     */
    public abstract void setDate(int month , int year);
    /**
     * 
     * @param overDraft
     */
    public abstract void setOverdraft(int overDraft);
    /**
     * 
     * @param money
     */
    public abstract void withdraw(double money);
    /**
     * 
     * @return
     */
    public abstract boolean getType();
    
}