package com.endpoints;

public class Routers {
	public static String base_url = "https://petstore.swagger.io/v2";
	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String update_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";

	// store
	public static String store_post_url = base_url + "/store/order";
	public static String store_get_url = base_url + "/store/order/{id}";
	public static String store_update_url = base_url + "/store/order/{id}";
	public static String store_delete_url = base_url + "/store/order/{id}";
}
