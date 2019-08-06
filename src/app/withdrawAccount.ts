import { Component } from "@angular/core";
import {EmployeeService} from './app.employeeService';
import {Account} from "./models/Account";
import { DepositAndWithdraw } from "./models/DepositAndWithdraw";
@Component({
    selector:'withdraw',
    templateUrl:'withdraw.html'
})



export class WithdrawAccountComponent{
    constructor(private service:EmployeeService){}
    model:DepositAndWithdraw=
    {
        id:0,
        amount:0
    }
    withdraw()
    {
        this.service.withdraw(this.model).subscribe(
            res=>console.log(res)
        )
    }
}