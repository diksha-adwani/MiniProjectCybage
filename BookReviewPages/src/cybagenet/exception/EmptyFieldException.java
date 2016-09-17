package cybagenet.exception;

@SuppressWarnings("serial")
public class EmptyFieldException extends Exception 
{
	String message;
	
	public EmptyFieldException() 
	{
	
	}
	
	public EmptyFieldException(String message) 
	{
		this.message = message;
	}
	
	@Override
	public String getMessage() 
	{
		return message;
	}
	
	@Override
	public String toString() {
	
		return "Each Field is Mandatory";
	}
}
