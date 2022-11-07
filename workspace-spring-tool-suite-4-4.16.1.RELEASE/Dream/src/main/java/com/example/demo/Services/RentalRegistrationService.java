package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import com.example.demo.Beans.RentalProductList;
import com.example.demo.Beans.RentalRegistrationBean;
import com.example.demo.Beans.RentalRegistrationResponse;
import com.example.demo.Beans.cameraDetailsBean;
import com.example.demo.Entities.CameraEntity;
import com.example.demo.Entities.RentalCameraDetailsEntity;
import com.example.demo.Repositories.RentalCameraDetailsRepo;
import com.example.demo.Repositories.RentalRegestrationRepo;

@Service
public class RentalRegistrationService {
 
	@Autowired
	RentalRegestrationRepo rentalregestrationRepo;
	
	@Autowired
	RentalCameraDetailsRepo rentalCameraDetailsRepo;
	
	public RentalRegistrationResponse saveRentalDetails(RentalRegistrationBean request) {
		CameraEntity rentalDetailsCheck = new CameraEntity(); 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		String date = dtf.format(now);
		String rentalCode = "";	
		RentalRegistrationResponse response = new RentalRegistrationResponse();
		rentalDetailsCheck = rentalregestrationRepo.findByRentalEmailAndIsActiveTrue(request.getRentalEmail());
		if(null != rentalDetailsCheck) {
			response.setStatus("Rental already Registered");
		}
		else {
			CameraEntity rentalDetails = new CameraEntity();
			if(null != request) {
				rentalDetails.setAddress(request.getAddress());
				rentalDetails.setCity(request.getCity());
				rentalDetails.setContact(request.getContact());
				rentalDetails.setRating("5");
				rentalDetails.setRentalEmail(request.getRentalEmail());
				rentalDetails.setRentalName(request.getRentalName());
				rentalDetails.setRegisteredDate(date);	
				rentalregestrationRepo.save(rentalDetails);
			}
			rentalDetails = rentalregestrationRepo.findByRentalEmailAndIsActiveTrue(request.getRentalEmail());
			if(null != rentalDetails) {
				rentalCode = String.valueOf(rentalDetails.getId()+100000);
				rentalDetails.setRentalCode(rentalCode);
				rentalregestrationRepo.save(rentalDetails);
				response.setStatus("Rental Registered Successfully");
				response.setCameraEntity(rentalDetails);
			}
			
		}
		return response;
	}

	public cameraDetailsBean saveRentalCameratDetails(RentalCameraDetailsEntity request) {
		cameraDetailsBean response = new cameraDetailsBean();
		if(null != request) {
			long min = 1000;  
			long max = 9999;   
			long otp = (int)(Math.random()*(max-min+1)+min); 
			String number = String.valueOf(otp);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");  
			LocalDateTime now = LocalDateTime.now(); 
			String date = "CAM"+dtf.format(now)+number;
			request.setProductNumber(date);
			rentalCameraDetailsRepo.save(request);
			response.setStatus("Product Added successfully");
			response.setRentalCameraDetailsEntity(request);
		}
		else {
			response.setStatus("Something went wrong in saving product details");
		}
		
		return response;
		
	}

	public List<RentalProductList> getRentalProductsList(String request) {
		List<RentalProductList> response = new ArrayList<RentalProductList>();
		if(null != request) {
			List<RentalCameraDetailsEntity> rentalDetailsList = rentalCameraDetailsRepo.findByRentalCodeAndIsActiveTrue(request);
			if(null != rentalDetailsList) {
				for(RentalCameraDetailsEntity obj : rentalDetailsList) {
					RentalProductList product = new RentalProductList();
					product.setCameraPhoto(obj.getCameraPhoto());
					product.setProductName(obj.getProductName());
					product.setProductNumber(obj.getProductNumber());
					product.setRentPerDay(obj.getRentPerDay());
					response.add(product);
				}
			}
		}
		return response;
	}

	public RentalCameraDetailsEntity getCameraDetails(String request) {
		RentalCameraDetailsEntity response = rentalCameraDetailsRepo.findByProductNumberAndIsActiveTrue(request);
		
		return response;
	}
}
