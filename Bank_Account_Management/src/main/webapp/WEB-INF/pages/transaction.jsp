<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="transaction.css">
    <style>
         body {
            background-color: rgb(177, 253, 200);
          }
              
    </style>
</head>

<body>
 
  <div class="flex">
  <div class="element-center">
    
    <div id="acctBalance">
        
            <span class="wrap"></span>
        </a>
        <h1>
            Secured Transcation 
        </h1>
        <label id="acctBalanceLbl"></label>
    </div>

    <div id="inputs">
    <form action="Deposit" method="POST">
        <h2>
            Deposit
        </h2>
        <input type="number" id="userDeposit" name="depositAmount" required>
        <input type="submit" value="Deposit">
	</form>
	<form action="Withdraw" method="POST">
        <h2>
            Withdraw
        </h2>
        <input type="number" id="userWithdraw" name="withdrawAmount" required>
        <input type="submit" value="withdraw">
    </form>
<br>
<br>
To view Transaction history, Click the button below.

   
        <form action="clientreport" method="GET">
          <br>
           <br>
            <button class="button">Transaction History</button>
         </form>
          
    </div>
  </div>
  </div>
 <br>
          <form action="home" method="GET">
          <br>
           <br>
            <button class="button">Home Page</button>
          </form>
  
    
    <script>
    const acctBalanceLbl = document.getElementById("acctBalanceLbl");
    const deposits = [];
    const withdrawals = [];
    let totalBalance = 25;
    const userDeposit = document.getElementById("userDeposit");
    const btnDeposit = document.getElementById("btnDeposit");
    const userWithdraw = document.getElementById("userWithdraw");
    const btnWithdraw = document.getElementById("btnWithdraw");

    const formatter = new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'USD',
        minimumFractionDigits: 2,
      });

    
    btnDeposit.addEventListener('click', () => {

       
        if (isNaN(userDeposit.value)) {
            alert("Please enter a number.");
            return userDeposit.value = '';
        } else {

      
            if (userDeposit.value < 0.01 || userDeposit.value > 10000) {
                alert("You can only deposit between $0.01 and $10,000.")
                return userDeposit.value = '';
            } else {
        
         
            deposits.push(Number(userDeposit.value));
           
            totalBalance += (Number(userDeposit.value));

            let totalBalanceFormatted = formatter.format(totalBalance);
            document.getElementById("acctBalanceLbl").innerHTML = totalBalanceFormatted;

        console.log("$" + userDeposit.value);
        return userDeposit.value = '';
        }
    }
        
    });

   
    btnWithdraw.addEventListener('click', () => {

        if (isNaN(userWithdraw.value)) {
            alert("Please enter a number.");
            return userWithdraw.value = '';
        } else {

            if (userWithdraw.value > totalBalance - 5) {
                alert("Your total balance cannot drop below $5.");
                return userWithdraw.value = '';
            } else {

            withdrawals.push(Number(userWithdraw.value));
          
            totalBalance -= (Number(userWithdraw.value));

            let totalBalanceFormatted = formatter.format(totalBalance);
            document.getElementById("acctBalanceLbl").innerHTML = totalBalanceFormatted;
        console.log("$" + userWithdraw.value);
        return userWithdraw.value = '';
        }
    }
    });
 let totalBalanceFormatted = formatter.format(totalBalance);
    document.getElementById("acctBalanceLbl").innerHTML = totalBalanceFormatted;

    </script>
    
</body>

</html>