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
    constructor(private http: HttpClient)
    {
		this.clientUrl = 'http://localhost:8090/Banking_System/login';
		this.newClient='http://localhost:8090/Banking_System/registor';
		this.transReport='http://localhost:8090/Banking_System/report'
    }
    public login(val : Login): Observable<Client> {
	let params = new HttpParams()
      .set('username', val.username)
      .set('password', val.password)
    return this.http.post<Client>(this.clientUrl,params);
   }
   public save(client: Client) {
    return this.http.post<Client>(this.newClient, client);
  }
   public getTransreport(client: Client) :  Observable<Transaction[]>{
    return this.http.post<Transaction[]>(this.transReport, client);
  }
}
