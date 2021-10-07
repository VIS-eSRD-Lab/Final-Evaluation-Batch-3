import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

const baseUrl = 'http://localhost:8081/';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(`${baseUrl}/student/get-all`);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`${baseUrl}/student/get/${id}`);
  }

}
