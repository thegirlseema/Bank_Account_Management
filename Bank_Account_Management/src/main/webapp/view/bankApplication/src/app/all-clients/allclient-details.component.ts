import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgModule } from '@angular/core';
import { Client } from '../model/client';
import { ClientService } from '../service/client.service';
import { Login } from '../model/login';

@Component({
  selector: 'app-balance',
  templateUrl: './allclient-details.component.html',
  styleUrls: ['./allclient-details.component.css']
})
export class AllClients implements OnInit {
  clients: Client[]=[];
  constructor(private router: Router,private clientService:ClientService, private route: ActivatedRoute) {
}

  ngOnInit(): void {

      this.clientService.allClient().subscribe(data =>{this.clients=data,this.setClient(this.clients)});
   
  }
  setClient(clients:Client[])
  {
    this.clients=clients;
  }
  logout() {
    this.router.navigate(['/login']);
  }
  home(){
    this.router.navigate([`/adminhome`]);
  }
  updateClient(accno:number)
  {
    this.router.navigate([`updateclient/${accno}`]);
  }
  deleteClient(accno:number){
    this.clientService.delete(accno).subscribe(data =>{
      if(data==true)
      {
        alert(accno+" Deleted Succusfully");
        this.clientService.allClient().subscribe(data =>{this.clients=data,this.setClient(this.clients)});
      }
      else{
        
      }
    });
  }
}
