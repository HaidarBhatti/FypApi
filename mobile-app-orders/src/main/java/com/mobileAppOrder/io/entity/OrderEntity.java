package com.mobileAppOrder.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "orders")
public class OrderEntity implements Serializable {

	private static final long serialVersionUID = -7487828728067012773L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String orderId;

	@Column(nullable = false)
	private String vehicleId;

	@Column(nullable = false, length = 30)
	private String personName;

	@Column(nullable = false, length = 15)
	private String phoneNumber;

	@Column(nullable = false, length = 200)
	private String address;

	@Column(nullable = false, length = 10)
	private String luggageWeight;

	@Column(nullable = false, length = 15)
	private String luggageType;

	@Column(nullable = false, length = 10)
	private String orderStatus;

	@Column(nullable = false, length = 15)
	private String date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
