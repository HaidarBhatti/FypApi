package com.mobileAppVehicle.shared.dto;

import java.io.Serializable;

public class VehicleDto implements Serializable {

	private static final long serialVersionUID = -6903981444253099964L;
	private long id;
	private String vehicleId;
	private String vehicleNo;
	private String vehicleName;
	private String weightCapacity;
	private String driverName;
	private String departurePlace;
	private String destinationPlace;
	private String departureTime;
	private String destinationTime;
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
