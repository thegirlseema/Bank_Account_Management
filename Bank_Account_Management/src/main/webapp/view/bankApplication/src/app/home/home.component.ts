import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../service/client.service';
import { Login } from '../model/login';
import { Client } from '../model/client';
import { ClientLoginComponent } from '../client-login/client-login.component';

@Component({
  selector: 'app-home-form',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  client: Client | undefined;
  public formData: any = {};
  private clientlogincom!: ClientLoginComponent;
  constructor(private route: ActivatedRoute,private router: Router) {
  }
  
  ngOnInit() {
      
    }
    
    registerPage(){
      this.router.navigate(['/registor']);
    }
    totalTransaction(){
      this.router.navigate(['/report']);
    }
    logout(){
      this.router.navigate(['/login']);
    }
    moneyTranfer(){
      this.router.navigate(['/moneytransfer']);
    }
  }
  