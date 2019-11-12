import { Component, OnInit } from "@angular/core";
import { CoordinatorService } from "../service/app.coordinatorservice";
import { CourseModel } from "../_model/app.coursemodel";
@Component({
    selector:'addcourse',
    templateUrl:'../coordinatorPart/app.addCourse.html',
    styleUrls:["../homePart/app.homepagecomponent.css"]
})
export class AddCourseComponent
{
    model:CourseModel={courseName:'', courseDescription:'', courseDuration:60, courseEndDate:null, courseId:-1, courseStartDate:null};
    errorMessage:any;
    constructor(private service:CoordinatorService)
    {
        this.model.courseStartDate=new Date();
        this.model.courseEndDate=new Date();
        this.model.courseEndDate.setMonth(this.model.courseStartDate.getMonth()+2);
    }
    addCourse():any
    {
        this.service.addCourse(this.model).subscribe((data:any)=>{alert("Course added successfully");
        location.reload();
    },error=>this.errorMessage=error.error);
    }
    idValid:boolean=false;
    validateId(){
        if(this.model.courseDuration>180){
            this.idValid=true;
        }
        else if(this.model.courseDuration<60){
            this.idValid=true;
        }else{
            this.idValid=false;
        }
    }
    datesValid:boolean=false;
    validateAirports(a:string, b:string){
        if(a===b){
            this.datesValid=true;
        }else{
            this.datesValid=false;
        }
    }
    nameValid:boolean=true;
    validateName(){
        this.nameValid=/^[a-zA-Z ]+$/.test(this.model.courseName);
        console.log(this.nameValid);
    }
    descriptionValid:boolean=true;
    validateDescription(){
        this.nameValid=/^[a-zA-Z ]+$/.test(this.model.courseDescription);
        console.log(this.descriptionValid);
    }



}
