import { Injectable } from '@angular/core';
import { Client } from '../pages/clients/client.model';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ViewForm } from '../commons/view-form.model';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  constructor(private httpClient: HttpClient) { }


  listClients(filter: any): Observable<any> {
    return this.httpClient.post<ViewForm>(environment.urlPathBase + 'clients/list', filter).pipe(catchError(err => this.catchAuthError(err)));
  }

  postClient(client: any): Observable<any>{
    return this.httpClient.post<ViewForm>(environment.urlPathBase + 'clients', client).pipe(catchError(err => this.catchAuthError(err)));
  }

  alterClient(client: any): Observable<any>{
    return this.httpClient.put<ViewForm>(environment.urlPathBase + 'clients/' + client.id, client).pipe(catchError(err => this.catchAuthError(err)));
  }

  deleteClient(id: any): Observable<any>{
    return this.httpClient.delete<ViewForm>(environment.urlPathBase + 'clients/' + id).pipe(catchError(err => this.catchAuthError(err)));
  }

  catchAuthError(error: any): Observable<Response>{
    console.log(error);
    alert(error.error.errors ?? error.message);
    return throwError(() => new Error(error));
  }
}
