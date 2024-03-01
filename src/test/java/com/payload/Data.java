package com.payload;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.endpoints.Routers;

import io.restassured.response.Response;
public class Data {
  public static Response CreateUser(User payload) {
	 Response response=given()
	  .accept("application/json")
	  .contentType("application/json")
	  .body(payload)
	  .when()
	  .post(Routers.post_url);
	 return response;

  }
  public static Response GetUser(String username) {
		 Response response=given()
		 .pathParam("username", username)
		  .when()
		  .get(Routers.get_url);
		return response;
	  }
  public static Response UpdateUser(User payload,String username) {
	 Response response=given()
	  .accept("application/json")
	  .contentType("application/json")
	  .pathParam("username",username)
	  .body(payload)
	  .when()
	  .put(Routers.update_url);
	 return response;

  }
  public static Response deleteUser(String username) {
		 Response response=given()
		 .pathParam("username", username)
		  .when()
		  .get(Routers.delete_url);
		return response;
	  }
}
