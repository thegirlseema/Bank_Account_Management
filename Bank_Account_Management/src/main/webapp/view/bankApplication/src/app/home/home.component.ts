import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../service/client.service';
import { Login } from '../model/login';
import { Client } from '../model/client';
import { ClientLoginComponent } from '../client-login/client-login.component';

@Component({
  selector: 'app-client-form',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

   client: Client | undefined;

  constructor(private clientlogincom: ClientLoginComponent) {

  }

  ngOnInit() {
    this.client=this.clientlogincom.getClient();
    }
  }
