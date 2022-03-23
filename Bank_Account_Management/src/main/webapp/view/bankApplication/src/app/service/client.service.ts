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
  private deposit: string;
  private withdraw: string;
  private httpHeaders = new HttpHeaders()
    .set('Content-Type', 'application/json')
    .set('Access-Control-Allow-Origin', 'localhost:4205');

  constructor(private http: HttpClient) {
    this.clientUrl = 'http://localhost:8090/Banking_System/login';
    this.newClient = 'http://localhost:8090/Banking_System/registor';
    this.transReport = 'http://localhost:8090/Banking_System/report';
    this.deposit = 'http://localhost:8090/Banking_System/deposit';
    this.withdraw = 'http://localhost:8090/Banking_System/withdraw';
  }

  public login(val: Login): Observable<Client> {
    let params = new HttpParams()
      .set('username', val.username)
      .set('password', val.password)
    return this.http.post<Client>(this.clientUrl, params);
  }
  public validatelogin(val: Login) {
    let params = new HttpParams()
      .set('username', val.username)
      .set('password', val.password)
    return this.http.post<boolean>(this.clientUrl, params);
  }
  
  public save(client: Client) {
    return this.http.post<Client>(this.newClient, client, { headers: this.httpHeaders });
  }
  public getTransreport(client: Client): Observable<Transaction[]> {
    return this.http.post<Transaction[]>(this.transReport, client, { headers: this.httpHeaders });
  }
  public moneydeposit(clientid: number, amount: number) {
    /*let params = new HttpParams()
      .set('amount', amount)
      .set('clientid', clientid)*/
    return this.http.post<Client>(this.deposit+"/"+clientid+"/"+amount,{ headers: this.httpHeaders });
  }
  public moneywithdraw(clientid: number, amount: number) {
    
    return this.http.post<Client>(this.withdraw+"/"+clientid+"/"+amount, { headers: this.httpHeaders });

  }
}
