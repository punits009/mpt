import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { AddEmployeeComponent } from './app.addEmployee';
import { ShowEmployeeComponent } from './app.showEmployee';
import { SearchEmployeeComponent } from './app.searchEmployee';
import {FormsModule} from '@angular/forms';
import {Routes,RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { UpdateAccountComponent } from './updateAccount';
import { DeleteAccountComponent } from './deleteAccount';
import { DepositAccountComponent } from './depositAccount';
import { WithdrawAccountComponent } from './withdrawAccount';
import { TransferAccountComponent } from './TransferAccount';
const routes:Routes=[
    {path:'',redirectTo:'show',pathMatch:'full'},
    {path:'add',component:AddEmployeeComponent},
    {path:'show',component:ShowEmployeeComponent},
    {path:'find',component:SearchEmployeeComponent},
    {path:'update',component:UpdateAccountComponent},
    {path:'delete',component:DeleteAccountComponent},
    {path:'withdraw',component: WithdrawAccountComponent},
    {path:'deposit',component:DepositAccountComponent},
    {path:'transfer',component:TransferAccountComponent},
    {path:'**',redirectTo:'show'},
];
@NgModule({
    imports: [
        BrowserModule,FormsModule,RouterModule.forRoot(routes),HttpClientModule
        
    ],
    declarations: [
        AppComponent,AddEmployeeComponent,ShowEmployeeComponent,SearchEmployeeComponent,UpdateAccountComponent,DeleteAccountComponent,DepositAccountComponent, WithdrawAccountComponent,TransferAccountComponent
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }
