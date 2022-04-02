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
  sClients: Client[]=[];
  sName:string='';
  searchStatus:boolean=false;
  totalStatus:boolean=true;
  constructor(private router: Router,private clientService:ClientService, private route: ActivatedRoute) {
}

  ngOnInit(): void {

      this.clientService.allClient().subscribe(data =>{this.clients=data,this.setClient(this.clients)});
   
  }
  setClient(clients:Client[])
  {
    this.clients=clients;
  }
  onSearch(){
    this.totalStatus=false;
    this.searchStatus=true;
    let len:number=this.sClients.length;
    for(let i=0 ;i<len;i++  )
    {
      this.sClients.pop();
    }
    for(let c of this.clients)
    {
      if(c.firstname.toLowerCase().startsWith(this.sName.toLowerCase()))
      {
        this.sClients.push(c);
      }
    }
  }
  onClose()
  {
    this.sName='';
    this.totalStatus=true;
    this.searchStatus=false;
    let len:number=this.sClients.length;
    console.log(len);
    for(let i=0 ;i<len;i++  )
    {
      this.sClients.pop();
    }
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
