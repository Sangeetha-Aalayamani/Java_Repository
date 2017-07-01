package bank.account.exceptions;

/**
 *
 * @author sangeetha
 */
public class InvalidDepositAmountException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1800077948537444579L;

	public InvalidDepositAmountException(String message)
	{
            super("Error Details: " + message);
	}
}
