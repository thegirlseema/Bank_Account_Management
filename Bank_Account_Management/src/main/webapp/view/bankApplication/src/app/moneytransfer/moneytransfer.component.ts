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
    private client:Client ;
     constructor(private route: ActivatedRoute, private router: Router, private clientService: ClientService) {
	this.client=new Client(0,'','','',0,0,'',0,0,'',0,'',0,'');
  this.login =  new Login();
  }

  ngOnInit(): void {
    
    this.route.params.subscribe((parameters)=>{

      this.login.username = String(parameters['username']);
      this.login.password = String(parameters['password']);

      this.clientService.login(this.login).subscribe(data =>{this.client=data,this.setClient(this.client.clientid)});

     
    });
    
  }
    setClient(clientid:number)
    {
      this.client.clientid=clientid;
    }
    onDeposit() {
      alert("Clientid"+this.client.clientid);
    this.clientService.moneydeposit(this.client.clientid,this.damount).subscribe(result => {this.gotoHomePage();
    });
  }
  gotoHomePage(){
    
    this.router.navigate([`home/${this.login.username}/${this.login.password}`]);
  }   
  onWithdraw() {
    alert("Clientid"+this.client.clientid);
    this.clientService.moneywithdraw(this.client.clientid,this.wamount).subscribe(result =>{this.gotoHomePage()});
  }
    
  }
