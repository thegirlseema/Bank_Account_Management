import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgModule } from '@angular/core';
import { Client } from '../model/client';
import { ClientService } from '../service/client.service';
import { Login } from '../model/login';

@Component({
  selector: 'app-balance',
  templateUrl: './client-balance.component.html',
  styleUrls: ['./client-balance.component.css']
})
export class ClientBalance implements OnInit {
  client: Client;
  login:Login;

  constructor(private router: Router,private clientService:ClientService, private route: ActivatedRoute) {
   
    this.client=new Client(0,'','','',0,0,'',0,0,'',0,'',0,'');
    this.login=new Login();
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

  home(){
    this.router.navigate([`home/${this.login.username}/${this.login.password}`]);
  }
  logout() {
    this.router.navigate(['/login']);
  }

}
