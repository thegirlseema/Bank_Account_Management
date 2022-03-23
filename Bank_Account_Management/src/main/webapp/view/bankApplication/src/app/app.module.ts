import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ClientLoginComponent } from './client-login/client-login.component';
import { ClientFormComponent } from './client-form/client-form.component';
import { ClientService } from './service/client.service';
import { MoneyTransaction } from './moneytransfer/moneytransfer.component';
import { TransactionComponent } from './transaction/transaction.component';
import { LastTransactionComponent } from './last-transaction/last-transaction.component';
import { ClientBalance } from './client-balance/client-balance.component';
import { AccountDetails } from './account-details/account-details.component';
@NgModule({
  declarations: [
    AppComponent,
    ClientLoginComponent,
    ClientFormComponent,
    MoneyTransaction,
    TransactionComponent,
    LastTransactionComponent,
    ClientBalance,
    AccountDetails
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
