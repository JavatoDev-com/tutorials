import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { catchError, retry } from 'rxjs/operators';

const apiBaseUrl = "http://localhost:8080/api/library"

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private apiClient : HttpClient) { }

  getAllAuthors(): Observable<any> {
    return this.apiClient.get(apiBaseUrl+'/author');
  }

  createAuthor(data): Observable<any> {
    console.log(data);
    return this.apiClient.post(apiBaseUrl+'/author', data);
  }
  
}
