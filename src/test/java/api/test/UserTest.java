package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payload.User;
import io.restassured.response.Response;


public class UserTest {
	
	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setupData()
	{
		faker=new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("****** Creating User *********");
		
		Response response=userEndPoints.createUser(userPayload);
		response.then().log().all();
		//System.out.println(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("****** Creating Created *********");
		
		
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		logger.info("****** Reading User *********");
		
		System.out.println(this.userPayload.getUsername());
		Response response=userEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("****** User Info Displayed *********");
		
	}
	
	@Test(priority=3)
	public void testUpdateUserByName()
	{
	
  // update using pay load 
		
		logger.info("****** Updating User *********");
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setPassword(faker.internet().password(5,10));
		
		Response response=userEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("****** User Updated *********");
		
 // checking user data after update
		
	    Response responsAfterUpdate=userEndPoints.readUser(this.userPayload.getUsername());
	    responsAfterUpdate.then().log().all();
		
		Assert.assertEquals(responsAfterUpdate.getStatusCode(), 200);
		
		logger.info("****** Updated User Updated *********");
		
		
		
	}
	
	
	@Test(priority=4)
	public void testDeleteUser()
	{
		logger.info("****** Deleting user *********");
		
		Response response=userEndPoints.deleteUser(this.userPayload.getUsername());
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("****** User Deleted *********");
	}
	
}
