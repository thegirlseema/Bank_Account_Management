export class Transaction {
    tid :number;
	tdate :string;
	username :string;
	type:string;
	amount:number;
	accountno:number;
	clientid : number;
	constructor(tid :number,
		tdate :string,
		username :string,
		type:string,
		amount:number,
		clientid : number,
		accountno:number){
		this.tid=tid;
		this.tdate=tdate;
		this.username=username;
		this.type=type;
		this.amount=amount;
		this.clientid=clientid;
		this.accountno=accountno;
	}
}
