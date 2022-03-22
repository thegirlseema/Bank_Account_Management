import { Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser'
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../service/client.service';
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
   transactions: Transaction[]=[];

  constructor(/*private clientlogincom: ClientLoginComponent,*/private router: Router,private clientService:ClientService) {
   
      this.client=new Client();
  }
  
    ngOnInit() {
      this.client.clientid=12;
    this.getTransaction();
    
    }
    home(){
      this.router.navigate(['/home']);
    }
    setClient(obj:Client)
    {
      this.client=obj;
    }
    getTransaction() {
        this.clientService.getTransreport(this.client).subscribe(data => {
      this.transactions = data,console.log(this.transactions);
    });
    }

    
  }
