import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../service/client.service';
import { Login } from '../model/login';
import { Client } from '../model/client';
import { TransactionComponent } from '../transaction/transaction.component';
import { HomeComponent } from '../home/home.component';

@Component({
  selector: 'app-login-form',
  templateUrl: './client-login.component.html',
  styleUrls: ['./client-login.component.css']
})
export class ClientLoginComponent implements OnInit{
  login: Login;
  client : Client;
  errormsg:string='';
  constructor(private route: ActivatedRoute, private router: Router, private clientService: ClientService) {
    this.login = new Login();
    this.client = this.client=new Client(0,'','','',0,0,'',0,0,'',0,'',0,'');
  }

  ngOnInit(): void {
      
  }
  getClient(){
	return this.client;
  }
  onSubmit() {
    this.clientService.login(this.login).subscribe(data => {this.client=data;
      if(this.client)
      {
        this.router.navigate([`home/${this.login.username}/${this.login.password}`]);
      }
      else{
        this.errormsg="Invalid Username/Password";
      }
      /*if(this.client.username==this.login.username && this.login.password==this.login.password)
      {
        this.router.navigate([`home/${this.login.username}/${this.login.password}`]);
      }
      else
      {
        this.errormsg="Invalid Username/Password";
      }*/
    });
    
  }

  gotoHomepage() {
    
    //this.router.navigate(['/home',{clientid:this.client.clientid}]);
  }
  
}
