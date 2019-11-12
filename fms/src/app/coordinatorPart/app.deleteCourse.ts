import { Component, OnInit } from "@angular/core";
import {CoordinatorService} from '../service/app.coordinatorservice';
import { Router } from "@angular/router";
import { CourseModel } from "../_model/app.coursemodel";
@Component({
    selector:'deletecourse',
    templateUrl:'../coordinatorPart/app.deleteCourse.html'

})
export class DeleteCourseComponent implements OnInit
{

    courseList:CourseModel[]=[];
    public popoverTitle:string='Delete Confirmation';
    public popoverMessage:string="Do you really want to delete the Course";
    public confirmClicked:boolean=false;
    public cancelClicked:boolean=false;
    public popoverTitle1:string='Delete Confirmation';
    public popoverMessage1:string="Do you really want to delete the Course";
    public confirmClicked1:boolean=false;
    public cancelClicked1:boolean=false;
    constructor(private service:CoordinatorService, private router:Router){
     }
     ngOnInit(){

        this.service.getCourse().subscribe((data:CourseModel[])=>this.courseList=data);

     }
        deleteCourse(courseId:any):any
        {
        this.service.deleteCourse(courseId).subscribe(
            (data:string) => {
                alert(data)
                this.service.getCourse().subscribe((data:CourseModel[])=>this.courseList=data);
            },
            //error => alert(error.message)

        );
        }
        editCourse(course:any)
        {

        }
}
