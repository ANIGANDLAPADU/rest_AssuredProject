package com.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.payload.User;
import com.payload.UserData;
import com.utilities.DataProviders;

import io.restassured.response.Response;

@Listeners(com.utilities.ExtentReportManager.class)
public class PetStoreTesting {

	public User userPayload;
	public Faker faker;

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void Create(String userID, String userName, String fname, String lname, String useremail, String pwd,
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

	}

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void get(String username) {
		Response response = UserData.getUser(username);
		response.then().log().all();
	}
	@Test(priority = 4,dataProvider ="UserNames",  dataProviderClass = DataProviders.class)
	public void delete(String username) {
		Response response = UserData.deleteUser(username);
		response.then().log().all();
	
	}
}
