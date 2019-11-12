import {Component,OnInit,OnChanges,OnDestroy} from '@angular/core';
import {RegistrationService} from '../service/app.registrationservice';
import {WalletUser} from '../_model/app.usermodel';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';

//to do list create a templateUrl for admin login component 
@Component({
    selector:'login',
    templateUrl:'./app.loginPage.html',
    styleUrls:["./app.loginPageCss.css"]
})
/**
	 *author: Utkarsh
     *Description : This class calls the service functions for login this 
                    class uses JWT tokens for login   
	 *created Date: 19/10/2019
	 *last modified : 19/10/2019            
	 */
export class LoginComponent implements OnInit{
    
    role:string
    username = ''
    password = ''
    invalidLogin = false
    user:any={};      

    constructor(private router: Router,private service:RegistrationService,private authService:AuthenticationService){
        console.log("NIn in constructor")
    }

    ngOnInit(): void {
        console.log("inside login component ")
    }
    authenticate(username,password):any{

        this.authService.authenticate(username,password)
        this.user=sessionStorage.getItem('token');
        this.authService.getDbUser(username);
        this.role=this.authService.getUser()
       
        
        this.invalidLogin = false
    }
    setInvalidLogin(status){
        this.invalidLogin=status
    }
    logOut(){
        
    }


}