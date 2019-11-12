import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';

export class User{
  constructor(
    public status:string,
     ) {}
  
}

@Injectable({
  providedIn: 'root'
})
/**
	 *author: Venkatesh
	 *Description : This class authenticates the user if a valid JWT token is present  
	 *created Date: 23/10/2019
	 *last modified : 23/10/2019            
	 */
export class AuthenticationService {

  user:any={}
  role:string

  constructor(
    private httpClient:HttpClient,private router: Router
  ) { 
     }
     //this function gets the username and passord from component and connects 
     //to the database for if credentials are valid then JWT token is retreived.
     authenticate(username, password) {
      return this.httpClient.post<any>('http://localhost:9050/authenticate',{username,password}) .subscribe
      (
        (data)=>{
          sessionStorage.setItem('username',username);
          let tokenStr='Bearer '+data.token;
          alert(tokenStr);
          sessionStorage.setItem('token',tokenStr);
          this.user=data;
          return data;
        },(error) => {
          this.router.navigate(['login'])
        }
      )
      
    }
  getDbUser(loginName):any{
    this.user=this.httpClient.get("http://localhost:9050/getUser?loginName="+loginName).subscribe(
      (data)=>{
        alert(data)
        alert(data["employeeRole"])
        
      if(data["employeeRole"]=='ROLE_ADMIN'){
        this.router.navigate(['/adminPage'])
      }
      else if (data["employeeRole"]=='ROLE_COORDINATOR'){
        this.router.navigate(['/addCourse'])
      }
      else if (data["employeeRole"]=='ROLE_PARTICIPANT'){
        this.router.navigate(['/viewFeedback'])
      }
      else{
        this.router.navigate(['/adminPage'])
      }
    
    })
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
  getUser(){
    
    return this.role;
  }
}