package com.mobileAppVehicle.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Vehicles") // this is the table name that will be created in the database
public class VehicleEntity implements Serializable {

	private static final long serialVersionUID = 8923198677322457464L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String vehicleId;

	@Column(nullable = false, length = 20)
	private String vehicleNo;

	@Column(nullable = false, length = 30)
	private String vehicleName;

	@Column(nullable = false, length = 20)
	private String weightCapacity;

	@Column(nullable = false, length = 30)
	private String driverName;

	@Column(nullable = false, length = 40)
	private String departurePlace;

	@Column(nullable = false, length = 40)
	private String destinationPlace;

	@Column(nullable = false, length = 20)
	private String departureTime;

	@Column(nullable = false, length = 20)
	private String destinationTime;

	@Column(nullable = false, length = 20)
	private String date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getWeightCapacity() {
		return weightCapacity;
	}

	public void setWeightCapacity(String weightCapacity) {
		this.weightCapacity = weightCapacity;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDeparturePlace() {
		return departurePlace;
	}

	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}

	public String getDestinationPlace() {
		return destinationPlace;
	}

	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(String destinationTime) {
		this.destinationTime = destinationTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
