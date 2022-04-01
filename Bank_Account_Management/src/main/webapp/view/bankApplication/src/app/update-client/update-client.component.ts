import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgModule } from '@angular/core';
import { Client } from '../model/client';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'update-client',
  templateUrl: './update-client.component.html',
  styleUrls: ['./update-client.component.css']
})
export class UpdateClient implements OnInit {
  client: Client;
  accno:number=0;

  constructor(private router: Router,private clientService:ClientService, private route: ActivatedRoute) {
   
    this.client=new Client(0,'','','',0,0,'',0,0,'',0,'',0,'');
    
}

  ngOnInit(): void {
    this.route.params.subscribe((parameters)=>{

      this.accno = Number(parameters['accno']);

      this.clientService.getClient(this.accno).subscribe(data =>{this.client=data,this.setClient(this.client)});
      
     
    });
   
  }
  onSubmit()
  {
    this.clientService.updateClient(this.client).subscribe(data =>{
      if(data===true)
      {
        alert("Updated Succesfully");
        this.home();
      }
      else
      {
        alert("Not Updated");
      }
    });
    
    
    
  }
  setClient(client:Client)
  {
    this.client=client;
  }
  logout() {
    this.router.navigate(['/login']);
  }
  home(){
    this.router.navigate([`/adminhome`]);
  }

}
