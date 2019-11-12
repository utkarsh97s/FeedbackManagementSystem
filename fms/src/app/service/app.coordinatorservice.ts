import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
export class User{
    constructor(
      public status:string,
       ) {}   
  }

  export class JwtResponse{
    constructor(
      public jwttoken:string,
       ) {}
    
  }

  @Injectable({
    providedIn: 'root'
})
export class CoordinatorService {
    userObject:any;

    constructor(private myhttp: HttpClient) { }


    getCourse() {
     
        return this.myhttp.get("http://localhost:9050/getCourseList");
    }
  
    addCourse(model: any) {
      alert(model);
    
      let form = new FormData();
      form.append("courseName",model.courseName)
      
      form.append("courseDuration",model.courseDuration)
      form.append("courseDescription",model.courseDescription)
      form.append("startDate",model.startDate)
      form.append("endDate",model.endDate);
        return this.myhttp.post("http://localhost:9050/addCourse",form);
    }
    deleteCourse(model: any){
      return this.myhttp.post("http://localhost:9050/deleteCourse",model);
    }
}