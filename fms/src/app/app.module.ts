import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import {FormsModule}      from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'; 

import {AdminComponent}  from './adminPart/app.admincomponent';
import {LoginComponent} from './loginPart/app.logincomponent';

import {FeedbackComponent} from './participantPart/app.feedback';
import {homePage} from './homePart/app.homecomponent';
import {Routes,RouterModule}  from '@angular/router'; 

import {logOut}  from './app.logOutcomponent'
    import { from } from 'rxjs';
import { AddCourseComponent } from './coordinatorPart/app.addCourse';
import { DeleteCourseComponent } from './coordinatorPart/app.deleteCourse';
//mapping of urls to components
const myroute:Routes=[
    {path:'login',component:LoginComponent},
    {path:'adminPage',component:AdminComponent},
    {path:'homePage',component:homePage},

    {path:'addCourse',component:AddCourseComponent},

    {path:'logOut',component:logOut},
    {path:'viewFeedback',component:FeedbackComponent},
    { path: '**', redirectTo: '/homePage', pathMatch: 'full' },
]

@NgModule({
    imports: [
        BrowserModule,FormsModule,HttpClientModule,RouterModule.forRoot(myroute)
        
    ],
    declarations: [
        AppComponent,AdminComponent,LoginComponent,homePage
        ,logOut,AddCourseComponent,DeleteCourseComponent,FeedbackComponent
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }