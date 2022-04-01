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
  
   tamount:number=0;
   login: Login;
   accountno:number=0;
   accounterr:string='';
   withdrawErr: string='';
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

  gotoHomePage(){
    this.withdrawErr="";
      
    this.router.navigate([`home/${this.login.username}/${this.login.password}`]);
  }   


  onTransfer() {
    this.accounterr="";
    this.withdrawErr="";
    if(((this.client.accountbalance-1000)>this.tamount) && (this.tamount>0)){
      
    this.clientService.moneytransfer(this.client.clientid,this.tamount,this.accountno).subscribe(result =>{this.validate(result)});
  }
  else{
    this.withdrawErr="Invalid amount";
  }
  }
  validate(results:Client)
  {
    if(results)
    {
      alert("Transferred Successfully");
      this.gotoHomePage();
    }
    else{
      this.accounterr="Wrong Account Number";
    }
  }
  logout() {
    this.router.navigate(['/login']);
  }
  }
