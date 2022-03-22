import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../service/client.service';
import { Login } from '../model/login';
import { Client } from '../model/client';
import { ClientLoginComponent } from '../client-login/client-login.component';
import { Transaction } from '../model/transaction';

@Component({
  selector: 'app-money-transfer',
  templateUrl: './moneytransfer.component.html',
  styleUrls: ['./moneytransfer.component.css']
})
export class MoneyTransaction{
   /* amount: number=0;

    private client:Client;
     constructor(private route: ActivatedRoute, private router: Router, private clientService: ClientService) {
	this.client=new Client();
  }
    onDeposit() {
    this.clientService.moneydeposit(this.client,this.amount).subscribe(result => {
        return this.gotoHomePage();
    });
  }
  gotoHomePage(){
	this.router.navigate(['/home']);
  }   
  onWithdraw() {
    this.clientService.moneywithdraw(this.client,this.amount).subscribe(result => this.gotoHomePage());
  }*/
    
  }
