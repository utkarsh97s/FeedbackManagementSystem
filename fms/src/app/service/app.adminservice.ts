import {Injectable} from '@angular/core';
import {HttpClient,HttpParams, HttpHeaders} from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
   providedIn:'root' 
})
/**
	 *author: Utkarsh
	 *Description : This class calls connects to the database for admin operations  
	 *created Date: 11/11/2019
	 *last modified : 11/11/2019            
	 */
export class AdminService{

    headers:any 

    constructor(private myhttp:HttpClient,private router:Router){
        this.headers = new HttpHeaders().set("Authorization",sessionStorage.getItem("token"));
        if(sessionStorage.getItem('username')==''){
            alert('inside cons user')
            this.router.navigate(['login'])
        }
    
    }
    //this function is calls the database for getting accouonts to be approved
    //this function uses JWT tokens for connecting to the database
    getCoordinators(){
        let username=sessionStorage.getItem('username');
        let token=sessionStorage.getItem('token');
       return this.myhttp.get('http://localhost:9050/getCoordinatorList',{headers:this.headers});
    }
    //this function is calls the database for coordinators
    //this function uses JWT tokens for connecting to the databas
    
    //this function removes the session
    logOut(){
        sessionStorage.removeItem('username');
        sessionStorage.removeItem('token')
    }

}