import { Injectable } from '@angular/core';
import { Http, Response } from "@angular/http";
import { Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CourseRegistration, Student } from 'src/app/classes/course-registration';

@Injectable({
  providedIn: 'root'
})
export class CourseRegistrationService {

  private apiUrl = 'http://localhost:8081/api/finalevaluation';


  constructor(private http: Http) {}

  findAll(): Promise<Array<CourseRegistration>> {
    const url = `${this.apiUrl}/course/registration/get/all`;
    return this.http.get(url)
    .toPromise()
    .then(response => response.json() as CourseRegistration[])
    .catch(this.handleError);
  }

  createCourseRegistration(courseRegistration: CourseRegistration): Promise<Array<CourseRegistration>> {
    const url = `${this.apiUrl}/course/registration/add`;
    
    let batchHeaders = new Headers({ 'Content-Type': 'application/json' });
    return this.http.post(url, JSON.stringify(courseRegistration), { headers: batchHeaders })
    .toPromise()
    .then(response => response.json() as CourseRegistration[])
    .catch(this.handleError);
  }

  findAllStudent(): Promise<Array<Student>> {
    const url = `${this.apiUrl}/student/get/all`;
    return this.http.get(url)
    .toPromise()
    .then(response => response.json() as Student[])
    .catch(this.handleError);
  }

  private handleError(error: any): Promise<Array<any>> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

}
