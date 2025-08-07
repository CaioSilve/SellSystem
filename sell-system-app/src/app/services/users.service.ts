import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ViewForm } from '../commons/view-form.model';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private httpClient: HttpClient) { }


  listUsers(filter: any): Observable<any> {
    return this.httpClient.post<ViewForm>(environment.urlPathBase + 'users/list', filter).pipe(catchError(err => this.catchAuthError(err)));
  }

  postUser(client: any): Observable<any>{
    return this.httpClient.post<ViewForm>(environment.urlPathBase + 'users', client).pipe(catchError(err => this.catchAuthError(err)));
  }

  alterUser(client: any): Observable<any>{
    return this.httpClient.put<ViewForm>(environment.urlPathBase + 'users/' + client.id, client).pipe(catchError(err => this.catchAuthError(err)));
  }

  deleteUser(id: any): Observable<any>{
    return this.httpClient.delete<ViewForm>(environment.urlPathBase + 'users/' + id).pipe(catchError(err => this.catchAuthError(err)));
  }

  catchAuthError(error: any): Observable<Response>{
    console.log(error);
    alert(error.error.errors ?? error.message);
    return throwError(() => new Error(error));
  }
}
