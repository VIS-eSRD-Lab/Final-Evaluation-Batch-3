import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, from } from 'rxjs';

const baseUrl = 'http://localhost:8081/api/'; 


@Injectable({
  providedIn: 'root'
})
export class TutorialService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(`${baseUrl}/get-all-tutorial`);
  }

  get(id: string): Observable<any> {
    return this.http.get(`${baseUrl}/get-tutorial/${id}`);
  }

  create(data: object): Observable<object> {
    return this.http.post(`${baseUrl}/add-tutorial`, data);
  }

  update(id: string, data: object): Observable<object> {
    return this.http.put(`${baseUrl}/update-tutorial/${id}`, data);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`${baseUrl}/delete-tutorial/${id}`);
  }
}
