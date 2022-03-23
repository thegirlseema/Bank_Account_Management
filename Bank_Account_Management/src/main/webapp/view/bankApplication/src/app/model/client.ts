export class Client {
    clientid: number;
    firstname: string;
    lastname: string;
    password: string;
    accountbalance: number;
    outstandingbalance: number;
    doj: string;
    withdraw: number;
    deposit: number;
    username: string;
    clientaccount: number;
    email:string;
    mobileno:number;
    clientaddress: string
    constructor(clientid: number,
        firstname: string,
        lastname: string,
        password: string,
        accountbalance: number,
        outstandingbalance: number,
        doj: string,
        withdraw: number,
        deposit: number,
        username: string,
        clientaccount: number,
        email:string,
        mobileno:number,
        clientaddress: string)

    {
        this.clientid=clientid;
        this.firstname=firstname;
        this.lastname=lastname;
        this.password=password;
        this.accountbalance=accountbalance;
        this.outstandingbalance=outstandingbalance;
        this.doj=doj;
        this.withdraw=withdraw;
        this.deposit=deposit;
        this.username=username;
        this.clientaccount=clientaccount;
        this.email=email;
        this.mobileno=mobileno;
        this.clientaddress=clientaddress
    }
   
  
}
/*{
	"clientid": 15,
	"firstname": "Jack",
	"lastname": "Sparrow",
	"username": "jack123",
	"password": "1234",
	"accountbalance": 11000,
	"outstandingbalance": 2000,
	"doj": "22/06/2021",
	"withdraw": 1000,
	"deposit": 3500,
	"clientaccount": 506655,
	"email": "jack123@gmail.com",
	"mobileno": 7558661454,
	"clientaddress": "Noida"
}*/