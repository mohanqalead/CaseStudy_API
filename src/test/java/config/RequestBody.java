package config;

public class RequestBody {
	
	public static String validLoginCredentials() {
		return "{\n" +
                "  \"email\": \"test@gmail.com\",\n" +
                "  \"password\": \"test\"\n" +
                "}";
	}
	
	public static String inValidLoginCredentials() {
		return "{\n" +
                "  \"email\": \"test@gmail.com\",\n" +
                "  \"password\": \"auto\"\n" +
                "}";
	}
	
	public static String missingPassword() {
		return "{\n" +
                "  \"email\": \"test@gmail.com\"\n" +
                "}";
	}
	
	public static String missingEmail() {
		return "{\n" +
                "  \"password\": \"auto\"\n" +
                "}";
	}
	

}
