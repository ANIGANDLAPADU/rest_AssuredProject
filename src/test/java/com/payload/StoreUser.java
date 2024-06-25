package com.payload;

public class StoreUser {
	int id;
	int petId;
	int quantity;
	String shipDate;
	String status;
	String complete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}

}
/*
 * { "id": 58570251, "petId": 0, "quantity": 0, "shipDate":
 * "2024-03-04T07:52:17.528+0000", "status": "placed", "complete": true }
 */