package com.mobileAppOrder.ui.model.response;

public class OrderRest {

	private String orderId;
	private String vehicleId;
	private String personName;
	private String phoneNumber;
	private String address;
	private String luggageWeight;
	private String luggageType;
	private String orderStatus;
	private String date;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLuggageWeight() {
		return luggageWeight;
	}

	public void setLuggageWeight(String luggageWeight) {
		this.luggageWeight = luggageWeight;
	}

	public String getLuggageType() {
		return luggageType;
	}

	public void setLuggageType(String luggageType) {
		this.luggageType = luggageType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
