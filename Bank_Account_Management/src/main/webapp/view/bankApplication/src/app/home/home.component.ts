import { Component, OnInit } from '@angular/core';
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
export class HomeComponent implements OnInit{

  client: Client | undefined;
  public formData: any = {};
  private clientlogincom!: ClientLoginComponent;
  constructor(private route: ActivatedRoute, private router: Router) {

  }

  ngOnInit(): void {
      
  }

  registerPage() {
    this.router.navigate(['/registor']);
  }

  totalTransaction() {
    this.route.params.subscribe((parameters)=>{
      console.log(String(parameters['username']));
      console.log(String(parameters['password']));
      this.router.navigate([`report/${String(parameters['username'])}/${String(parameters['password'])}`]);
    });

    // this.bookService.findByName(String(parameters['loginid'])).subscribe(allbook=>this.Books=allbook);
    //this.router.navigate(['/report'])
  }

  logout() {
    this.router.navigate(['/login']);
  }
  moneyTranfer() {
    this.route.params.subscribe((parameters)=>{
      console.log(String(parameters['username']));
      console.log(String(parameters['password']));
      this.router.navigate([`moneytransfer/${String(parameters['username'])}/${String(parameters['password'])}`]);
    });
    }
}
