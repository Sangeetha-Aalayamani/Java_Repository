
package bank.account.exceptions;

/**
 *
 * @author sangeetha
 */
public class InvalidInterestRateException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2728787895466892021L;

	public InvalidInterestRateException(String message)
	{
		super("Error Details: " + message);
	}
}
