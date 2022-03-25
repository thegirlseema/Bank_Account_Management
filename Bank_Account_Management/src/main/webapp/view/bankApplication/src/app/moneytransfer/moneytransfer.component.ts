import { Component, OnInit } from '@angular/core';
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
export class MoneyTransaction implements OnInit{
  
   damount:number=0;
   wamount:number=0;
   login: Login;
   withdrawErr: string='';
   depositErr:string='';
    private client:Client ;
     constructor(private route: ActivatedRoute, private router: Router, private clientService: ClientService) {
	this.client=new Client(0,'','','',0,0,'',0,0,'',0,'',0,'');
  this.login =  new Login();
  }

  ngOnInit(): void {
    
    this.route.params.subscribe((parameters)=>{

      this.login.username = String(parameters['username']);
      this.login.password = String(parameters['password']);

      this.clientService.login(this.login).subscribe(data =>{this.client=data,this.setClient(this.client)});

     
    });
    
  }
  setClient(client:Client)
  {
    this.client=client;
  }
    onDeposit() {
      this.depositErr='';
        if(this.damount>0)
        {
        alert("Deposit Successfully");
        this.clientService.moneydeposit(this.client.clientid,this.damount).subscribe(result => {this.gotoHomePage();
      });
    }
    else{
        this.depositErr="Invalid amount";
    }
    

  }
  gotoHomePage(){
    
    this.router.navigate([`home/${this.login.username}/${this.login.password}`]);
  }   
  onWithdraw() {
    if(((this.client.accountbalance-1000)>this.wamount) && (this.wamount>0)){
      this.withdrawErr="";
      alert("Withdraw Successfully");
    this.clientService.moneywithdraw(this.client.clientid,this.wamount).subscribe(result =>{this.gotoHomePage()});
  }
  else{
    this.withdrawErr="Invalid amount";
  }
  }
  logout() {
    this.router.navigate(['/login']);
  }
  }
