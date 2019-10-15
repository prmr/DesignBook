package chapter5;

public class NumberLoader
{
	public static void main(String[] args)
	{
		if( args.length != 2) error("Invalid number of arguments");
		try
		{
			Class<?> numberClass = Class.forName("java.lang." + args[0]);
			Number number  = (Number) numberClass.getDeclaredMethod("valueOf", String.class).invoke(null, args[1]);
			System.out.println(number + " is a number of type " + number.getClass().getName());
		}
		catch(ReflectiveOperationException exception)
		{
			error("Invalid number type");
		}
		catch(NumberFormatException exception)
		{
			error("Invalid number format");
		}
	}
	
	private static void error(String pMessage)
	{
		System.out.println(pMessage);
		System.exit(1);
	}
}
