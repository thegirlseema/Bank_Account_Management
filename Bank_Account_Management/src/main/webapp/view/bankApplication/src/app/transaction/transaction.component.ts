import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../service/client.service';
import { Login } from '../model/login';
import { Client } from '../model/client';
import { ClientLoginComponent } from '../client-login/client-login.component';
import { Transaction } from '../model/transaction';

@Component({
  selector: 'app-client-form',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent {

   private client: Client;
   private transactions: Transaction[]=[];

  constructor(private clientlogincom: ClientLoginComponent,private clientService:ClientService) {
      this.client=new Client();
  }
  
  ngOnInit() {
    this.client=this.clientlogincom.getClient();
    this.getTransaction();
    
    }
    getTransaction() {
        this.clientService.getTransreport(this.client).subscribe(data => {
      this.transactions = data;
    });
    }

    
  }
