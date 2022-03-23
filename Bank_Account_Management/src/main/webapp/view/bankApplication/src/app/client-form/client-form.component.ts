import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../service/client.service';
import { Client } from '../model/client';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent {

  client: Client;
  errormsg:string='';
  constructor(private route: ActivatedRoute, private router: Router, 
    private clientService: ClientService) {
    this.client=this.client=new Client(0,'','','',0,0,'',0,0,'',0,'',0,'');

  }

  onSubmit() {

    this.clientService.save(this.client).subscribe(result => {
      if(result)
      {
        this.gotoLogInPage();
      }
      else
      {
        this.errormsg="Username / Account number is already exist"; 
      }
    });//this.gotoLogInPage());
  }
  
  
  gotoLogInPage() {
    this.router.navigate(['/login']);
  }
}
