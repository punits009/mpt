import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {Observable} from 'rxjs';
import {Account} from './models/Account';
import { DepositAndWithdraw } from "./models/DepositAndWithdraw";
import { TransferModel } from "./models/TransferModel";

let baseUrl = "http://localhost:5000/accounts";

@Injectable({
    providedIn:'root'
})

export class EmployeeService{
    constructor(private http:HttpClient){}

    acc:Account;
    createAccount(account: Account) :Observable<Account> 
    {
        let options = { "headers": 
                    new HttpHeaders({"Content-Type": "application/json" }) };
         return this.http.post<Account>("http://localhost:5000/accounts"+ "/new",account,options);
    }

    getemployee()
    {       
          return this.http.get<Account[]>(baseUrl+"/");
    }
    findemployee(id:number){
        let options = { "headers": 
        new HttpHeaders({"Content-Type": "application/json" }) };
        return this.http.get<Account>(baseUrl+"/find/"+id,options);

    }
    update(account:Account,pid:number)
    {
        let options = { "headers": 
        new HttpHeaders({"Content-Type": "application/json" }) };
        return this.http.put<Account>(baseUrl+"/update/"+pid,account,options);

    }
    delete(id:number)
    {
        let options = { "headers": 
        new HttpHeaders({"Content-Type": "application/json" }) };
        return this.http.delete<Account>(baseUrl+"/delete/"+id,options);

    }
    deposit(model:DepositAndWithdraw)
    {
        let options = { "headers": 
        new HttpHeaders({"Content-Type": "application/json" }) };
        return this.http.put<Account>(baseUrl+"/deposit",model,options)
    }
    withdraw(model:DepositAndWithdraw)
    {
        let options = { "headers": 
        new HttpHeaders({"Content-Type": "application/json" }) };
        return this.http.put<Account>(baseUrl+"/withdraw",model,options)
    }
    transfer(model:TransferModel){
        let options = { "headers": 
        new HttpHeaders({"Content-Type": "application/json" }) };
        return this.http.put<Account>(baseUrl+"/transfer",model,options)
    }
}

   