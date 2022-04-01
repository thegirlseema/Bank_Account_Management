import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountDetails } from './account-details/account-details.component';
import { AdminHomeComponent } from './admin-home/adminhome.component';
import { AllClients } from './all-clients/allclient-details.component';
import { ClientBalance } from './client-balance/client-balance.component';
import { ClientFormComponent } from './client-form/client-form.component';
import { ClientLoginComponent } from './client-login/client-login.component';
import { HomeComponent } from './home/home.component';
import { LastTransactionComponent } from './last-transaction/last-transaction.component';

import { MoneyTransaction } from './moneytransfer/moneytransfer.component';
import { TransactionComponent } from './transaction/transaction.component';
import { UpdateClient } from './update-client/update-client.component';

const routes: Routes = [
  { path: '',pathMatch:"full", redirectTo:"login"},
	{ path: 'registor', component: ClientFormComponent },
  { path: 'login', component: ClientLoginComponent },
  { path: 'home/:username/:password', component: HomeComponent },
  { path: 'report/:username/:password', component: TransactionComponent },
  { path: 'moneytransfer/:username/:password', component: MoneyTransaction },
  { path: 'lasttrans/:username/:password', component: LastTransactionComponent },
  {path: 'balance/:username/:password', component: ClientBalance},
  {path: 'accountdetails/:username/:password', component: AccountDetails},
  {path: 'adminhome', component: AdminHomeComponent},
  {path: 'allclient', component: AllClients},
  {path: 'updateclient/:accno', component: UpdateClient}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
