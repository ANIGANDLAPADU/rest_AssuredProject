package com.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.payload.Data;
import com.payload.User;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Listeners(com.utilities.ExtentReportManager.class)
public class Testing {
	public Faker faker;
	public User payload;
	static Logger logger;

	public static Logger getLogger() {
		logger = LogManager.getLogger(); 
		return logger;
	}

	@BeforeTest
	public void data() {
		faker = new Faker();
		getLogger().info("faker instance got created ");
		payload = new User();
		payload.setId(faker.idNumber().hashCode());
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());
		payload.setUsername(faker.name().username());
		payload.setPassword(faker.internet().password(5, 10));
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPhone(faker.phoneNumber().cellPhone());

	}

	@Test(priority = 1)
	public void Creating() {
		Response response = Data.CreateUser(payload);
		response.then().log().all();
	}

	@Test(priority = 2)
	public void Getting() {
		Response response = Data.GetUser(this.payload.getUsername());
		response.then().log().all();
	}

	@Test(priority = 3)
	public void update() {
		Response response = Data.UpdateUser(payload, this.payload.getUsername());
		response.then().log().all();
	}

	@Test(priority = 4)
	public void delete() {
		Response response = Data.deleteUser(this.payload.getUsername());
		response.then().log().all();
	}
}
