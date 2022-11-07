package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Beans.ForgotPass;
import com.example.demo.Beans.LoginRequest;
import com.example.demo.Beans.OTPCheck;
import com.example.demo.Beans.RegisterRequest;
import com.example.demo.Entities.AuthenticationEntity;
import com.example.demo.Services.LoginDetailsServices;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")


public class LoginController {
	@Autowired
	LoginDetailsServices loginDetailsService;
	
	@PostMapping(value = "/login", produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String Login(@RequestBody LoginRequest request) {
		String response = loginDetailsService.getLoginDetails(request);
		return response;
	}
	
	@PostMapping(value = "/register", produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RegisterRequest Login(@RequestBody AuthenticationEntity request) {
		RegisterRequest response = loginDetailsService.saveRegestrationDetails(request);
		return response;
	}
	
	@PostMapping(value = "/forgotPassword", produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String ForgotPassword(@RequestBody ForgotPass request) {
		String response = loginDetailsService.forgotPasswordCheck(request);
		return response;
	}
	
	@PostMapping(value = "/otpCheck", produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String OtpCheck(@RequestBody  OTPCheck request) {
		String response = loginDetailsService.otpCheck(request);
		return response;
	}
	
	@PostMapping(value = "/saveNewPassword", produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String NewPassword(@RequestBody  OTPCheck request) {
		String response = loginDetailsService.saveNewPassword(request);
		return response;
	}
}
