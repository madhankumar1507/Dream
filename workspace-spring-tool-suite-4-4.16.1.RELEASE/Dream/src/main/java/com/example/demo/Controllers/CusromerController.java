package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Beans.BookingDetailsRequestBean;
import com.example.demo.Beans.RentalRegistrationBean;
import com.example.demo.Beans.RentalRegistrationResponse;
import com.example.demo.Entities.CameraEntity;
import com.example.demo.Services.CustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class CusromerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping(value = "/getRentalsByCity", produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CameraEntity> rentalRegistration(@RequestBody String request) {
		List<CameraEntity> response = customerService.getRentalsByCity(request);
		return response;
	}
	@PostMapping(value = "/bookProduct", produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BookingDetailsRequestBean rentalRegistration(@RequestBody BookingDetailsRequestBean request) {
		BookingDetailsRequestBean response = customerService.saveBookingDetails(request);
		return response;
	}
}
