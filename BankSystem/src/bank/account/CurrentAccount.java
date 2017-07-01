/**
 * The class CurrentAccount is sub class of class Account.
 */
package bank.account;

import bank.account.exceptions.InvalidOverdraftLimitException;
import bank.account.exceptions.InvalidWithdrawAmountException;

/**
 * 
 * @author sangeetha
 *
 */
public class CurrentAccount extends Account 
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5477307014199590161L;	
	private int overdraft = 500 ;
      
	/**
	 * one overdraft limit is ranging from 500 to 10,000,000
	 * @param acc
	 * @param money
	 * @param od
	 * @throws InvalidOverdraftLimitException
	 */
    CurrentAccount(String acc , double money , int od) throws InvalidOverdraftLimitException
    {
        super(acc);
        amount = money ;
        if (od >= 500 && od <= 10000000)        //if statement is not neccessary here.
        {
        	overdraft = od ;
        }
        else
        {
            throw new InvalidOverdraftLimitException("Overdraft limit is out of the range.");
        }
    }

    /*----------------
     * (non-Javadoc)
     * @see bank.Account#setOverdraft(int)
     */
    public void setOverdraft(int overDraft) throws InvalidOverdraftLimitException
    {
        if (overDraft < 500 && overDraft > 10000000)
        {
            throw new InvalidOverdraftLimitException("Overdraft limit is out of range.");
        }
        else
        	overdraft = overDraft;        
    }

   /*-----------
    * (non-Javadoc)
    * @see bank.Account#withdraw(double)
    */
    public void withdraw(double money) throws InvalidWithdrawAmountException
    {
        if (money <= amount+overdraft)
        {
            amount -= money ;
            
        }
        else
        {
            throw new InvalidWithdrawAmountException("Insufficient balance.");
        }
    }
    
   /*-------------
    * (non-Javadoc)
    * @see bank.Account#getType()
    */
     public boolean getType()
    {
        return true;
    }
     
    /*----------
     * (non-Javadoc)
     * @see bank.Account#addInterest(int, int)
     */
    public boolean addInterest(int month , int year)
    {
        return true;
    }

    /*-------------
     * (non-Javadoc)
     * @see bank.Account#setDate(int, int)
     */
	public void setDate(int month, int year) {
	}
	
    /*-------------
     * (non-Javadoc)
     * @see bank.Account#setInterest(float)
     */
	public void setInterest(float rate) {
	}
}