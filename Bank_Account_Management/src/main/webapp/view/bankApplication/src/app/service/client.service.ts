import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Client } from '../model/client';
import { Transaction } from '../model/transaction';
import { Observable } from 'rxjs';
import { Login } from '../model/login';
//import { Observable } from 'rxjs-compat/Observable';

@Injectable()
export class ClientService {
  private clientUrl: string;
  private newClient: string;
  private transReport: string;
  private httpHeaders = new HttpHeaders()
  .set('Content-Type', 'application/json')
  .set('Access-Control-Allow-Origin', 'localhost:4205');

  constructor(private http: HttpClient) {
    this.clientUrl = 'http://localhost:8090/Banking_System/login';
    this.newClient = 'http://localhost:8090/Banking_System/registor';
    this.transReport = 'http://localhost:8090/Banking_System/report'
  }
  public login(val: Login): Observable<Client> {
    let params = new HttpParams()
      .set('username', val.username)
      .set('password', val.password)
    return this.http.post<Client>(this.clientUrl, params);
  }
  public save(client: Client): Observable<Object> {
    return this.http.post(this.newClient, client, { headers: this.httpHeaders });
  }

  public getTransreport(client: Client): Observable<Transaction[]> {
    return this.http.post<Transaction[]>(this.transReport, client);
  }
}
