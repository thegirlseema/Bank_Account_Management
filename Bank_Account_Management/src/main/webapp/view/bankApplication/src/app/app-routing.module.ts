import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientFormComponent } from './client-form/client-form.component';
import { ClientLoginComponent } from './client-login/client-login.component';
import { HomeComponent } from './home/home.component';
import { MoneyTransaction } from './moneytransfer/moneytransfer.component';
import { TransactionComponent } from './transaction/transaction.component';

const routes: Routes = [
	{ path: 'registor', component: ClientFormComponent },
  { path: 'login', component: ClientLoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'report', component: TransactionComponent },
  { path: 'moneytransfer', component: MoneyTransaction }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
