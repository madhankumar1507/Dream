import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HomeserviceService } from '../homeservice.service';

@Component({
  selector: 'app-forgotpass',
  templateUrl: './forgotpass.component.html',
  styleUrls: ['./forgotpass.component.css']
})
export class ForgotpassComponent implements OnInit {
  public k=0;
  public m=0;
  public email="";
  public otp="";
  public backOtp="";
  public span1=0;
  public span2=0;

  constructor(private homeservice:HomeserviceService, private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
  }
GetOtp(){
  const data = {
    "emailId":this.email
  };
  this.homeservice.sendOtp(data).subscribe(ans =>{
    console.log(ans);
    if(this.email=="" || ans=="Not An User"){
         this.span1=1;
    }
    else{
      this.backOtp=ans;
    this.k=1;
    }
    
  });
}
sendOtp(){
  console.log(this.otp)
    console.log(this.backOtp)
    const data={
      "emailId":this.email,
      "otp":this.otp,
      "password":""
    }
    this.homeservice.CheckOtp(data).subscribe(ans =>{
      console.log(ans)
      if(ans=="Yes"){
        this.k=0
    this.m=1;
      }
      else{
        this.span2=1;
      }
      
    });
}
}
