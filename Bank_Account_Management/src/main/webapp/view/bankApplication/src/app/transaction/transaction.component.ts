import { NgModule } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser'
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../service/client.service';
import { Client } from '../model/client';
import { Login } from '../model/login';
import { ClientLoginComponent } from '../client-login/client-login.component';
import { Transaction } from '../model/transaction';

@Component({
  selector: 'app-client-form',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

  public client: Client;
  transactions: Transaction[] = [];
  login: Login;

  constructor(private router: Router, private clientService: ClientService, private route: ActivatedRoute) {

    this.client = this.client=new Client(0,'','','',0,0,'',0,0,'',0,'',0,'');
    this.login =  new Login();
  }

  ngOnInit(): void {
    
    this.route.params.subscribe((parameters)=>{

      console.log(String(parameters['username']));
      console.log(String(parameters['password']));

      this.login.username = String(parameters['username']);
      this.login.password = String(parameters['password']);

      this.clientService.login(this.login).subscribe(data =>{this.client=data,this.getTransaction(this.client.clientid)});

     
    });
    
  }

  home() {
    this.router.navigate([`home/${this.login.username}/${this.login.password}`]);
  }
  
  getTransaction(clientid:number) {
    this.client.clientid = clientid;
    this.clientService.getTransreport(this.client).subscribe(data => {
      this.transactions = data;
    });
  }


}
