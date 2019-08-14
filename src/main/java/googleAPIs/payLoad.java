package googleAPIs;

public class payLoad {

	//you can call any method from class to your testcase by giving classname.method name if that method name is defined as static
	public static String getRegiser()
	{
	
		String b ="{\r\n" + 
				"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
				"    \"password\": \"pistol\"\r\n" + 
				"}";
		
		
		return b;
	}
	public static String createPlaceData()
	{;
		String b="{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}";
	return b;
	}
}
