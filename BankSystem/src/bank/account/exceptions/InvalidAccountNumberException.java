package bank.account.exceptions;

/**
 *
 * @author sangeetha
 */
public class InvalidAccountNumberException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5721292582550345908L;

	public InvalidAccountNumberException(String message)
	{
            super("Error Details: " + message);
	}
}