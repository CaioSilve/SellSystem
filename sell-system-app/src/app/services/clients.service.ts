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


  //unused
  listClients(filtro: any): Observable<any> {
    return this.httpClient.post<ViewForm>(environment.urlPathBase + 'clients/list', filtro).pipe(catchError(err => this.catchAuthError(err)));
  }

  postClient(client: any): Observable<any>{
    return this.httpClient.post<ViewForm>(environment.urlPathBase + 'clients', client);
  }

  alterClient(client: any): Observable<any>{
    return this.httpClient.put<ViewForm>(environment.urlPathBase + 'clients/' + client.id, client);
  }

  deleteClient(id: any): Observable<any>{
    return this.httpClient.delete<ViewForm>(environment.urlPathBase + 'clients/' + id);
  }

  catchAuthError(error: any): Observable<Response>{
    console.log(error);
    alert(error);
    return throwError(() => new Error(error));
  }
}
