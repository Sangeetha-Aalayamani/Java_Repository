package bank.account.exceptions;

/**
 *
 * @author sangeetha
 */

public class InvalidWithdrawAmountException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6361790869811524314L;

	public InvalidWithdrawAmountException(String message)
	{
		super("Error Details: " + message);
	}
}