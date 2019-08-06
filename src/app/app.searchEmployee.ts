import { Component } from "@angular/core";
import {EmployeeService} from './app.employeeService';
import {Account} from "./models/Account";
@Component({
    selector:'search-emp',
    templateUrl:'searchemployee.html'
})



export class SearchEmployeeComponent{
    acc:Account
    constructor(private service:EmployeeService){}
    id:number;
    ch=false;
    change()
    {
        this.ch=true;
    }
    finddata()
    {
      console.log(this.id)
        this.service.findemployee(this.id).subscribe(
            res=>{
                this.acc=res
            },
            err=>{
                alert("an error has occurred")
            }
        )     
    }
}