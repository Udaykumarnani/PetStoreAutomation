package api.endpoints;

/*
swagger pet store url = https://petstore.swagger.io/

https://petstore.swagger.io/v2/user -- Post
https://petstore.swagger.io/v2/user/{username}  ---- Get
https://petstore.swagger.io/v2/user/{username}  ---- Put
https://petstore.swagger.io/v2/user/{username}  ---- Delete

*/
public class Routes {
	
	
	public static String base_url="https://petstore.swagger.io/v2";
	
 // user module
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	
 // Pet Module
	
	// pet module url's
	
 // Store Module	
	
	// store module url's
	
}
