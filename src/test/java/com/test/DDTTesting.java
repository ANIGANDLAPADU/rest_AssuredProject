package com.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.payload.Data;
import com.payload.User;
import com.payload.UserData;
import com.utilities.DataProviders;

import io.restassured.response.Response;

@Listeners(com.utilities.ExtentReportManager.class)
public class DDTTesting {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostuser(String userID, String userName, String fname, String lname, String useremail, String pwd,
			String ph) {
		User userPayload = new User();

		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstname(fname);
		userPayload.setLastname(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);

		Response response = UserData.CreateUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testgetUserByName(String username) {
		Response response = UserData.getUser(username);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testUpdateuser(String userID, String userName, String fname, String lname, String useremail, String pwd,
			String ph) {
		User userPayload = new User();

		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstname(fname);
		userPayload.setLastname(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);

		Response response = UserData.UpdateUser(userName, userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 3, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String userName) {
		Response response = Data.deleteUser(userName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
