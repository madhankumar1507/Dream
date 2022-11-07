package com.example.demo.Beans;

import com.example.demo.Entities.RentalCameraDetailsEntity;

public class BookingDetailsRequestBean {
    private RentalCameraDetailsEntity cameraDetails;
    private String startDate;
    private String endDate;
    private String accept;
    private String orderId;
    private String finalPrice;
    private boolean isActive;
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public RentalCameraDetailsEntity getCameraDetails() {
		return cameraDetails;
	}
	public void setCameraDetails(RentalCameraDetailsEntity cameraDetails) {
		this.cameraDetails = cameraDetails;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(String finalPrice) {
		this.finalPrice = finalPrice;
	}
    
	
}
