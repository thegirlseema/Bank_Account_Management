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
  confirmPassword: string='';
  missmatch:string='';
  constructor(private route: ActivatedRoute, private router: Router, 
    private clientService: ClientService) {
    this.client=this.client=new Client(0,'','','',0,0,'',0,0,'',0,'',0,'');

  }

  onSubmit() {

    if(this.client.password==this.confirmPassword){
      this.missmatch="";
      this.clientService.save(this.client).subscribe(result => {console.log(result);
        if(result==true)
        {
          this.gotoLogInPage();
        }
        else
        {
          this.errormsg="Username / Account number / Mobile number is already exist"; 
        }
      });
    }
    else
    {
      this.missmatch="Passwords are not matching";
    }
  }
  
  
  gotoLogInPage() {
    this.router.navigate(['/login']);
  }
}
