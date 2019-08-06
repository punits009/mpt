import { Component} from "@angular/core";
import {EmployeeService} from './app.employeeService';
import {Account} from './models/Account';

@Component({
    selector:'update',
    templateUrl:'update.html'
})

export class UpdateAccountComponent {
    model:Account={
        id:0,
        phone:'',
        accountHolder:"",
        balance:0.0
    }
  
    acc:Account
    constructor(private service:EmployeeService){}
    update()
    {
       this.service.update(this.model,this.model.id).subscribe(
        res=>{this.acc=res
       },
       err=>{
           alert("an error has occured")
       }
           
       )
    }
    ch=false;
    change(){
        this.ch=true;
    }

    
    
}