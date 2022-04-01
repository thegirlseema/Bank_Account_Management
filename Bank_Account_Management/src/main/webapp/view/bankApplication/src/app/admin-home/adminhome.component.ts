import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../service/client.service';
import { Login } from '../model/login';
import { Client } from '../model/client';
import { ClientLoginComponent } from '../client-login/client-login.component';

@Component({
  selector: 'admin-home-form',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminHomeComponent implements OnInit{
  public dAccount:number=0;
  public uAccount:number=0;
  public deletestatus:boolean=false;
  public updatestatus:boolean=false;
  public uErr:string='';
  public dErr:string='';
  public formData: any = {};
  private clientlogincom!: ClientLoginComponent;
  constructor(private route: ActivatedRoute, private router: Router,private clientService: ClientService) {

  }

  ngOnInit(): void {
      
  }

  addclient(){
      this.router.navigate([`/registor`]);

  }

  allclient() {
    
      this.router.navigate([`/allclient`]);

  }
  enabedelete(){
    this.dErr='';
      this.deletestatus=!this.deletestatus;
  }
  enabeupdate(){
    this.uErr='';
    this.updatestatus=!this.updatestatus;
  }
  deleteClient(){
    this.dErr='';
    this.clientService.delete(this.dAccount).subscribe(data =>{
      if(data==true)
      {
        this.deletestatus=false;
        alert(this.dAccount+" Deleted Succusfully");
      }
      else{
        this.dErr="Invalid Account Number";
      }
    });

  }
  updateClient(){
    this.uErr='';
    this.clientService.checkClient(this.uAccount).subscribe(data =>{console.log(data);
      if(data===true)
      {
        this.uErr="Client is there";
      }
      else{
        this.uErr="Invalid Account Number";
      }
    });

  }
  

  logout() {
    this.router.navigate(['/login']);
  }
  
    
}
