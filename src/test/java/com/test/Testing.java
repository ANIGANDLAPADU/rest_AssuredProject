package com.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.payload.Data;
import com.payload.User;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class Testing {
	public Faker faker;
	public User payload;

	@BeforeClass
	public void data() {
		faker = new Faker();
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
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("User.json"));

	}

	@Test(priority = 3)
	public void update() {
		Response response = Data.UpdateUser(payload,this.payload.getUsername());
		response.then().log().all();
	}

	@Test(priority = 4)
	public void delete() {
		Response response = Data.deleteUser(this.payload.getUsername());
		response.then().log().all();
	}
}
