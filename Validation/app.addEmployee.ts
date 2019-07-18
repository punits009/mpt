import { Component } from "@angular/core";


@Component({
    selector:'add-emp',//css selector for AddEmployeeComponent
    templateUrl:'addemployee.html'//view for AddEmployeeComponent
})


export class AddEmployeeComponent{
    uName:string;
    uAddress:string;
    uPincode:number;
    status:boolean=false;//status will tell whether form is valid or not.
    validate()
    {
        if(this.uName=='' || this.uAddress=='' || (this.uPincode==null && this.uPincode))//checking for emptiness of any of name,address or pincode
        {
            this.status=false;
        }
        else{
            this.status=true;
        }
    }

}