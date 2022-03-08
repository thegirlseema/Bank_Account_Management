create table clientdetail(clientid number(10),clientname VARCHAR2(20),username VARCHAR2(20),password VARCHAR2(20),accountbalance VARCHAR2(20),outstandingbalance VARCHAR2(20),
doj VARCHAR2(20),withdraw number(10),deposit number(10),ACCOUNTNUMBER number(10),primary key (clientid));

Insert into CLIENTDETAIL (CLIENTID,CLIENTNAME,USERNAME,PASSWORD,ACCOUNTBALANCE,OUTSTANDINGBALANCE,DOJ,WITHDRAW,DEPOSIT,ACCOUNTNUMBER) values (10,'Robert','rob123','1234',5000,1000,'12/07/2021',2000,1500,501234);

Insert into CLIENTDETAIL (CLIENTID,CLIENTNAME,USERNAME,PASSWORD,ACCOUNTBALANCE,OUTSTANDINGBALANCE,DOJ,WITHDRAW,DEPOSIT,ACCOUNTNUMBER) values (12,'Alex','alex123','1234',10000,2500,'10/09/2021',1000,2500,501678);

Insert into CLIENTDETAIL (CLIENTID,CLIENTNAME,USERNAME,PASSWORD,ACCOUNTBALANCE,OUTSTANDINGBALANCE,DOJ,WITHDRAW,DEPOSIT,ACCOUNTNUMBER) values (14,'Balu','balu123','1234',15000,2000,'01/06/2021',5000,1500,502055);

Insert into CLIENTDETAIL (CLIENTID,CLIENTNAME,USERNAME,PASSWORD,ACCOUNTBALANCE,OUTSTANDINGBALANCE,DOJ,WITHDRAW,DEPOSIT,ACCOUNTNUMBER) values (15,'Jack','jack123','1234',12000,2000,'22/06/2021',1000,3500,506655);
------------------------------
------------------------------
create table TRANSACTIONDET (sno number(10),tdate varchar(20),username varchar(20),type varchar(20),amount number(10),primary key(sno));
insert into TRANSACTIONDET values(10,'15-02-2022 10:11:53','rob123','Deposit',1000);
insert into TRANSACTIONDET values(11,'16-02-2022 12:11:53','balu123','Deposit',1500);
insert into TRANSACTIONDET values(12,'16-02-2022 13:11:53','alex123','Withdraw',1000);
insert into TRANSACTIONDET values(13,'17-02-2022 08:11:53','jack123','Deposit',500);
insert into TRANSACTIONDET values(14,'18-02-2022 15:15:23','rob123','Withdraw',500);
insert into TRANSACTIONDET values(15,'18-02-2022 18:01:45','alex123','Deposit',1500);
insert into TRANSACTIONDET values(16,'19-02-2022 11:11:53','rob123','Deposit',1500);
insert into TRANSACTIONDET values(17,'19-02-2022 07:11:53','balu123','Deposit',700);
insert into TRANSACTIONDET values(18,'20-02-2022 18:11:53','alex123','Withdraw',1500);
insert into TRANSACTIONDET values(19,'20-02-2022 18:11:53','jack123','Deposit',500);
insert into TRANSACTIONDET values(20,'21-02-2022 20:15:23','rob123','Withdraw',1200);
insert into TRANSACTIONDET values(21,'21-02-2022 16:01:45','alex123','Deposit',800);
insert into TRANSACTIONDET values(22,'21-02-2022 10:05:15','alex123','Withdraw',1200);
insert into TRANSACTIONDET values(23,'22-02-2022 10:11:53','rob123','Withdraw',800);
insert into TRANSACTIONDET values(24,'22-02-2022 20:15:54','balu123','Withdraw',500);
insert into TRANSACTIONDET values(25,'23-02-2022 15:01:13','alex123','Deposit',1000);
insert into TRANSACTIONDET values(26,'23-02-2022 11:11:43','jack123','Deposit',500);
insert into TRANSACTIONDET values(27,'24-02-2022 22:15:02','rob123','Deposit',2000);
insert into TRANSACTIONDET values(28,'24-02-2022 15:01:45','alex123','Deposit',1700);



