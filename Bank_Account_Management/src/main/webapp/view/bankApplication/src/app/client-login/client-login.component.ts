import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../service/client.service';
import { Login } from '../model/login';
import { Client } from '../model/client';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-login.component.html',
  styleUrls: ['./client-login.component.css']
})
export class ClientLoginComponent {
  

  login: Login;
  client :Client | undefined;

  constructor(private route: ActivatedRoute, private router: Router, private clientService: ClientService) {
    this.login = new Login();
  }
  getClient(){
	return this.client;
  }
  onSubmit() {
    this.clientService.login(this.login).subscribe(data => {this.client=data,this.gotoUserList()});
  }

  gotoUserList() {
    this.router.navigate(['/home']);
  }
}
