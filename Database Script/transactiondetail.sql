CREATE  TABLE TRANSACTIONDETAIL(
TID number(19) NOT NULL,
USERNAME VARCHAR2(25) ,
TDATE VARCHAR2(25),
type varchar(20),amount number(10),CLIENTID NUMBER,
foreign key(CLIENTID) references CLIENTDET(CLIENTID),
PRIMARY KEY (TID));
insert into TRANSACTIONDETAIL values(10,'rob123','15-02-2022 10:11:53','Deposit',1000,10);
insert into TRANSACTIONDETAIL values(11,'balu123','16-02-2022 12:11:53','Deposit',1500,14);
insert into TRANSACTIONDETAIL values(12,'alex123','16-02-2022 13:11:53','Withdraw',1000,12);
insert into TRANSACTIONDETAIL values(13,'jack123','17-02-2022 08:11:53','Deposit',500,15);
insert into TRANSACTIONDETAIL values(14,'rob123','18-02-2022 15:15:23','Withdraw',500,10);
insert into TRANSACTIONDETAIL values(15,'alex123','18-02-2022 18:01:45','Deposit',1500,12);
insert into TRANSACTIONDETAIL values(16,'rob123','19-02-2022 11:11:53','Deposit',1500,10);
insert into TRANSACTIONDETAIL values(17,'balu123','19-02-2022 07:11:53','Deposit',700,14);
insert into TRANSACTIONDETAIL values(18,'alex123','20-02-2022 18:11:53','Withdraw',1500,12);
insert into TRANSACTIONDETAIL values(19,'jack123','20-02-2022 18:11:53','Deposit',500,15);
insert into TRANSACTIONDETAIL values(20,'rob123','21-02-2022 20:15:23','Withdraw',1200,10);
insert into TRANSACTIONDETAIL values(21,'alex123','21-02-2022 16:01:45','Deposit',800,12);
insert into TRANSACTIONDETAIL values(22,'alex123','21-02-2022 10:05:15','Withdraw',1200,12);
insert into TRANSACTIONDETAIL values(23,'rob123','22-02-2022 10:11:53','Withdraw',800,10);
insert into TRANSACTIONDETAIL values(24,'balu123','22-02-2022 20:15:54','Withdraw',500,14);
insert into TRANSACTIONDETAIL values(25,'alex123','23-02-2022 15:01:13','Deposit',1000,12);
insert into TRANSACTIONDETAIL values(26,'jack123','23-02-2022 11:11:43','Deposit',500,15);
insert into TRANSACTIONDETAIL values(27,'rob123','24-02-2022 22:15:02','Deposit',2000,10);
insert into TRANSACTIONDETAIL values(28,'alex123','24-02-2022 15:01:45','Deposit',1700,12);
insert into TRANSACTIONDETAIL values(50,'sanjay123','16-02-2022 13:11:53','Withdraw',1000,87);
insert into TRANSACTIONDETAIL values(51,'sanjay123','18-02-2022 18:01:45','Deposit',1500,87);
insert into TRANSACTIONDETAIL values(52,'sanjay123','20-02-2022 18:11:53','Withdraw',1500,87);
insert into TRANSACTIONDETAIL values(53,'sanjay123','21-02-2022 16:01:45','Deposit',800,87);
insert into TRANSACTIONDETAIL values(54,'sanjay123','21-02-2022 10:05:15','Withdraw',1200,87);
insert into TRANSACTIONDETAIL values(55,'sanjay123','23-02-2022 15:01:13','Deposit',1000,87);
insert into TRANSACTIONDETAIL values(56,'sanjay123','24-02-2022 15:01:45','Deposit',1700,87);

