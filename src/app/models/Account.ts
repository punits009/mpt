export class Account{
    
    id:number;
    phone:string;
    accountHolder:string;
    balance:number;
    constructor(id,phone,accountHolder,balance)
    {
        this.id=id;
        this.phone=phone;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }
}