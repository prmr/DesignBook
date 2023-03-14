package chapter5;

public class NumberLoader
{
	public static void main(String[] args)
	{
		/*?
		 * Keyword: error
		 * This method is used to print an error message and exit the program. It is used to handle invalid arguments.
		 */
		if( args.length != 2) error("Invalid number of arguments");
		/*?
		 * Keyword: try
		 * The try block is used to handle exceptions. The try block is followed by one or more catch blocks. The catch block is used to handle the exception.
		 */
		try
		{
			/*?
			 * Keyword: Class
			 * The `Class` class is the superclass of all classes. Here, we are using `Class` to get the class for the specified number type.
			 * 
			 * Keyword: forName
			 * The `Class.forName` method is used to get the class for the specified name. The name is specified as a string. The method returns a `Class` object for the specified class name and throws a `ClassNotFoundException` if the class is not found.
			 * 
			 * Internal: ClassNotFoundException
			 * forName
			 * The `ClassNotFoundException` is thrown by the `Class.forName` method if the class is not found. The `ClassNotFoundException` is a subclass of `ReflectiveOperationException`. The `ReflectiveOperationException` is a superclass of all exceptions that can be thrown by reflection.
			 * 
			 * Internal: reflection
			 * ClassNotFoundException
			 * Reflection is the ability of a program to examine, inspect, and modify its own structure and behavior at runtime. Reflection is used to get the class for the specified number type. 
			 * 
			 * Keyword: java.lang
			 * The `java.lang` package contains the classes for the Java language. The `java.lang` package is automatically imported. We apped the class name to `java.lang` to get the class for the specified number type. For example, if the number type is `Integer`, then the class name is `java.lang.Integer`.
			 */
			Class<?> numberClass = Class.forName("java.lang." + args[0]);
			/*?
			 * Keyword: Number
			 * The `Number` class is the superclass of all numeric classes. Here, we are using `Number` to get the class for the specified number type. By casting the `Class` object to `Number`, we can use the `Number` methods on the `Class` object.
			 * 
			 * Internal: casting
			 * Number
			 * Casting is the ability to convert an object of one type to another type. Here, we are casting the `Class` object to `Number`. The `Class` object is converted to a `Number` object.
			 * 
			 * Keyword: getDeclaredMethod
			 * The `getDeclaredMethod` method is used to get the method for the specified name and parameter types. The method returns a `Method` object for the specified method name and parameter types and throws a `NoSuchMethodException` if the method is not found.
			 * 
			 * Internal: name
			 * getDeclaredMethod
			 * The method name is specified as a string. The method name is `valueOf`. The method name is case sensitive.
			 * 
			 * Internal: parameter types
			 * getDeclaredMethod
			 * The parameter types are specified as an array of `Class` objects. The parameter types are `String.class`. The parameter types are case sensitive.
			 * 
			 * Internal: noSuchMethodException
			 * getDeclaredMethod
			 * The `NoSuchMethodException` is thrown by the `getDeclaredMethod` method if the method is not found. The `NoSuchMethodException` is a subclass of `ReflectiveOperationException`. The `ReflectiveOperationException` is a superclass of all exceptions that can be thrown by reflection.
			 * 
			 * Keyword: valueOf
			 * The `valueOf` method is used to get the number for the specified string. The method returns a `Number` object for the specified string and throws a `NumberFormatException` if the string is not a valid number. For example, valueOf("123") returns the number 123.
			 * 
			 * Internal: numberFormatException
			 * valueOf
			 * The `NumberFormatException` is thrown by the `valueOf` method if the string is not a valid number. The `NumberFormatException` is a subclass of `IllegalArgumentException`.
			 * 
			 * Keyword: invoke
			 * The `invoke` method is used to invoke the specified method on the specified object. The method returns the result of the method invocation. To invoke is to call a method. Invoke takes two arguments. The first argument is the object on which the method is invoked. The second argument is an array of arguments for the method.
			 *
			 */
			Number number  = (Number) numberClass.getDeclaredMethod("valueOf", String.class).invoke(null, args[1]);
			/*?
			 * Keyword: getClass
			 * The `getClass` method is used to get the class for the specified object. The method returns a `Class` object for the specified object.
			 * 
			 * Keyword: getName
			 * The `getName` method is used to get the name of the specified class. The method returns a string for the specified class. So, number.getClass().getName() returns the name of the class for the number.
			 * 
			 */
			System.out.println(number + " is a number of type " + number.getClass().getName());
		}
		/*?
		 * Keyword: catch
		 * The catch block is used to handle the exception. The catch block is followed by the exception type. The exception type is the type of the exception that is handled by the catch block.
		 * 
		 * Keyword: ReflectiveOperationException
		 * The `ReflectiveOperationException` is a superclass of all exceptions that can be thrown by reflection. Here, we are using `ReflectiveOperationException` to handle the `ClassNotFoundException` and `NoSuchMethodException` exceptions.
		 * 
		 * Internal: classNotFoundException
		 * ReflectiveOperationException
		 * The `ClassNotFoundException` is thrown by the `Class.forName` method if the class is not found. The `ClassNotFoundException` is a subclass of `ReflectiveOperationException`. The `ReflectiveOperationException` is a superclass of all exceptions that can be thrown by reflection.
		 * 
		 * Internal: noSuchMethodException
		 * ReflectiveOperationException
		 * The `NoSuchMethodException` is thrown by the `getDeclaredMethod` method if the method is not found. The `NoSuchMethodException` is a subclass of `ReflectiveOperationException`. The `ReflectiveOperationException` is a superclass of all exceptions that can be thrown by reflection.
		 * 
		 * Internal: reflection
		 * ReflectiveOperationException
		 * Reflection is the ability of a program to examine, inspect, and modify its own structure and behavior at runtime. 
		 */
		catch(ReflectiveOperationException exception)
		{
			error("Invalid number type");
		}
		/*?
		 * Keyword: NumberFormatException
		 * The `NumberFormatException` is thrown by the `valueOf` method if the string is not a valid number. The `NumberFormatException` is a subclass of `IllegalArgumentException`.
		 */
		catch(NumberFormatException exception)
		{
			error("Invalid number format");
		}
	}
	
	/*?
	 * Keyword: error
	 * The `error` method is used to print the specified message and exit the program with a non-zero exit code. The method prints the specified message and exits the program with a non-zero exit code.
	 */
	private static void error(String pMessage)
	{
		System.out.println(pMessage);
		/*?
		 * Keyword: exit
		 * The `System.exit` method is used to exit the program with the specified exit code. The method exits the program with the specified exit code. The exit code is an integer. The exit code is 0 if the program exits normally. The exit code is non-zero if the program exits abnormally.
		 */
		System.exit(1);
	}
}
