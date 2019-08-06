import { Component,} from "@angular/core";
import {EmployeeService} from './app.employeeService';
import {Account} from './models/Account';

@Component({
    selector:'show-emp',
    templateUrl:'showemployee.html'
})

export class ShowEmployeeComponent {
    constructor(private service:EmployeeService){}
    acc:Account[]=[];
    ngOnInit(): void {
        //throw new Error("Method not implemented.");
        this.service.getemployee().subscribe(
            res=>{
               this.acc=res

            },
            err=>{
                alert("an error has occurred")
            }
        )
       } 


    
    
}