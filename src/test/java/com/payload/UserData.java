package com.payload;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import com.endpoints.Routers;

import io.restassured.response.Response;

public class UserData {
	
	public static ResourceBundle readUrl() {
		
		ResourceBundle resource = ResourceBundle.getBundle("routers");
		return resource;
	}
	public static Response CreateUser(User userPayload)   {
		Response response = given()
				.accept("application/json")
				.contentType("application/json")
				.body(userPayload)
				.when()
				.post(readUrl().getString("post_url"));
	         return response;

	}

	public static Response UpdateUser(String username, User payload) {
		Response response = given()
				.accept("application/json")
				.contentType("application/json")
				.body(payload)
				.pathParam("username", username)
				.when()
				.put(Routers.update_url);
		return response;

	}
	public static Response getUser(String username) {
		Response response = given()
				.pathParam("username", username)
				.when()
				.get(readUrl().getString("get_url"));
		return response;

	}
	public static Response deleteUser(String username) {
		Response response = given()
				.pathParam("username", username)
				.when()
				.delete(Routers.delete_url);
		return response;

	}

}
