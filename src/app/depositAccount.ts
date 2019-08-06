import { Component } from "@angular/core";
import {EmployeeService} from './app.employeeService';
import {Account} from "./models/Account";
import { DepositAndWithdraw } from "./models/DepositAndWithdraw";
@Component({
    selector:'deposit',
    templateUrl:'deposit.html'
})



export class DepositAccountComponent{
    constructor(private service:EmployeeService){}
    model:DepositAndWithdraw=
    {
        id:0,
        amount:0
    }
    deposit()
    {
        this.service.deposit(this.model).subscribe(
            res=>console.log(res)
        )
    }
}