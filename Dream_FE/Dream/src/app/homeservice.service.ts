import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Homeclass } from './homeclass';
@Injectable({
  providedIn: 'root'
})
export class HomeserviceService {

  constructor(private httpClient:HttpClient) { }
  baseUrl="http://localhost:8080/v1";
  login(data:Homeclass): Observable<any>{
    return this.httpClient.post("http://localhost:8080/v1/login",data,{responseType: 'text'});
  }
}
