package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	      User userPayload;

	    @Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
		public void testPostUser(String id,String userName,String fname,String lname,String email,String pwd,String ph)
		{
		    userPayload=new User();
			userPayload.setId(Integer.parseInt(id));
			userPayload.setUsername(userName);
			userPayload.setFirstName(fname);
			userPayload.setLastName(lname);
			userPayload.setEmail(email);
			userPayload.setPassword(pwd);
			userPayload.setPhone(ph);
			
			Response response=userEndPoints.createUser(userPayload);
			response.then().log().all();
			
			Assert.assertEquals(response.getStatusCode(),200);
		}
	    
	    @Test(priority=2,dataProvider="UserNames", dataProviderClass=DataProviders.class)
	    public void testGetUserByName(String userName)
	    {
	    	Response response=userEndPoints.readUser(userName);
	    	response.then().log().all();
	    	
	    	Assert.assertEquals(response.getStatusCode(), 200);
	    }
	    
	    
	    @Test(priority=3, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	    public void testDeleteUserByName(String userName)
	    {
	    	Response response=userEndPoints.deleteUser(userName);
	    	Assert.assertEquals(response.getStatusCode(),200);
	    }
}
