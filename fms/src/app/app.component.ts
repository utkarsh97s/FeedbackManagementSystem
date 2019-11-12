import { Component} from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app',
    templateUrl: 'app.component.html',
    
})
/**
	 *author: Venkatesh
	 *created Date: 23/10/2019
	 *last modified : 23/10/2019            
	 */
export class AppComponent  {
    constructor(private router:Router){
        if(sessionStorage.getItem('username')==''){
            alert('inside cons user')
            router.navigate(['login'])
          }
    }

}