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
  private transfer: string;
  private deposit: string;
  private withdraw: string;
  private loginValidate: string;
 
  private httpHeaders = new HttpHeaders()
    .set('Content-Type', 'application/json')
    .set('Access-Control-Allow-Origin', 'localhost:4205');
  allclient: string;
  deleteclient: string;
  checkclient: string;
  updateclient: string;
  getclient: string;
  

  constructor(private http: HttpClient) {
    this.loginValidate = 'http://localhost:8090/Banking_System/validatelogin';
    this.clientUrl = 'http://localhost:8090/Banking_System/login';
    this.newClient = 'http://localhost:8090/Banking_System/registor';
    this.transReport = 'http://localhost:8090/Banking_System/report';
    this.transfer = 'http://localhost:8090/Banking_System/transfer';
    this.deposit = 'http://localhost:8090/Banking_System/deposit';
    this.withdraw = 'http://localhost:8090/Banking_System/withdraw';
    this.allclient = 'http://localhost:8090/Banking_System/allClient';
    this.deleteclient = 'http://localhost:8090/Banking_System/deleteclient';
    this.checkclient = 'http://localhost:8090/Banking_System/checkclient';
    this.updateclient = 'http://localhost:8090/Banking_System/updateclient';
    this.getclient = 'http://localhost:8090/Banking_System/getClient';
  }

  public login(val: Login): Observable<Client> {
    let params = new HttpParams()
      .set('username', val.username)
      .set('password', val.password)
    return this.http.post<Client>(this.clientUrl, params);
  }

  public validatelogin(val: Login): Observable<Client> {
    let params = new HttpParams()
      .set('username', val.username)
      .set('password', val.password)
    return this.http.post<Client>(this.loginValidate, params);
  }
  public save(client: Client) {
    return this.http.post<boolean>(this.newClient, client, { headers: this.httpHeaders });
  }
  public allClient():Observable<Client[]> {
    return this.http.get<Client[]>(this.allclient,{ headers: this.httpHeaders });
  }
  public delete(accno:number) {
    return this.http.delete<boolean>(this.deleteclient+"/"+accno,{ headers: this.httpHeaders });
  }
  public checkClient(accno:number) {
    return this.http.get<boolean>(this.checkclient+"/"+accno,{ headers: this.httpHeaders });
  }
  public updateClient(client:Client) {
    return this.http.post<boolean>(this.updateclient,client,{ headers: this.httpHeaders });
  }
  public getClient(accno:number) : Observable<Client>{
    return this.http.get<Client>(this.getclient+"/"+accno,{ headers: this.httpHeaders });
  }
  public getTransreport(client: Client): Observable<Transaction[]> {
    return this.http.post<Transaction[]>(this.transReport, client, { headers: this.httpHeaders });
  }
  public moneytransfer(clientid: number, amount: number,accountno:number) {
    return this.http.post<Client>(this.transfer+"/"+clientid+"/"+amount+"/"+accountno,{ headers: this.httpHeaders });
  }
  public moneydeposit(clientid: number, amount: number) {
    return this.http.post<Client>(this.deposit+"/"+clientid+"/"+amount,{ headers: this.httpHeaders });
  }
  public moneywithdraw(clientid: number, amount: number) {    
    return this.http.post<Client>(this.withdraw+"/"+clientid+"/"+amount, { headers: this.httpHeaders });
  }
}
