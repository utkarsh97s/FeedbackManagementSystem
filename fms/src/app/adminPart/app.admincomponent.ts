import {Component,OnInit,OnChanges,OnDestroy} from '@angular/core';
import {AdminService} from '../service/app.adminservice';
import { Router } from '@angular/router';


@Component({
    selector:'admin',
    templateUrl:'./app.adminPage.html',
    styleUrls:["./app.adminPage.css"]
})
/**
	 *author: Utkarsh
	 *Description : This class calls the service functions for admin operations  
	 *created Date: 19/10/2019
	 *last modified : 19/10/2019            
	 */
export class AdminComponent implements OnInit{

    coordinators:any=[]

    constructor(private service:AdminService,private router:Router){
        console.log("NIn in constructor admin constructor service");
        this.service.getCoordinators().subscribe((data)=>{this.coordinators=data;
            alert("gfdsgdfg"+data)
            alert(this.coordinators)
            }
        ,(err) => {
            alert("qwerty")
            this.coordinators=err.error
            alert(err.error)
            console.log("inside error");
          });
    }

    ngOnInit(): void {
        console.log("inside registration component ")
        if(sessionStorage.getItem('username')==''){
            this.router.navigate(['login'])
        }
    }

    //this function updates returns the coordinators
    getCoordinators():any{
        return this.coordinators;
    }
  
    
}