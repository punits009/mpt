import { Component, OnInit } from "@angular/core";
import {EmployeeService} from './app.employeeService';
import { Account } from "./models/Account";
@Component({
    selector:'add-emp',
    templateUrl:'addemployee.html'
})


export class AddEmployeeComponent implements OnInit{
    
    id:number;
    phone:string;
    accountHolder:string;
    balance:number;
    acc:Account
    constructor(private service:EmployeeService){}
    ngOnInit(){}
  
    save()
    {
       
        var  account:Account=new Account(this.id,this.phone,this.accountHolder,this.balance);
        console.log(account);
        this.service.createAccount(account).subscribe(
            res=>{
                this.acc=res
            }
        );     
    }   
    ch=false;
    change(){
        this.ch=true;
    } 
}