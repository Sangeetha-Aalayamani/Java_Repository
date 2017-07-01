package bank.account.exceptions;

/**
 *
 * @author sangeetha
 */
public class InvalidOverdraftLimitException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3191981403485398006L;

	public InvalidOverdraftLimitException(String message)
	{
		super("Error Details: " + message);
	}
}