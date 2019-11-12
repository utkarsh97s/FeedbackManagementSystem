import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
   providedIn:'root' 
})
/**
	 *author: Venkatesh
	 *Description : This class calls connects to the database for registration
	 *created Date: 20/10/2019
	 *last modified : 20/10/2019            
	 */
export class RegistrationService{

    constructor(private myhttp:HttpClient){}
    //this function gets the params from component and then registers the user
    registerUser(data:any){
 
      let form = new FormData();
      form.append("userName",data.userName);
      form.append("userPassword",data.userPassword);
      form.append("phoneNo",data.phoneNo);
      return this.myhttp.post("http://13.233.48.144:9050/getRegistrationDetails",form);
    }

}