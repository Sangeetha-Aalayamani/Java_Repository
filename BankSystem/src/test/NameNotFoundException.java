package test;

/**
 * 
 * @author sangeetha
 *
 */
public class NameNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2458484198749977069L;

	public NameNotFoundException(String errorMessage)
	{
		super("Error Details: " + errorMessage);
	}
}
