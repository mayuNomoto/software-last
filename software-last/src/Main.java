
//package software-last;

public class Main {

	public static void main (String [] args) 
	{
		
		//***********************************
		// 課題 [1] 
		//***********************************
		
		//MyAccount インスタンス化
		MyAccount myAcc = new MyAccount();
		
		//以下、学籍番号G20194の例：

		//口座番号の設定
		myAcc.setAccNum(94);
		
		//暗証番号の設定
		myAcc.setPass(20194);
		
		//残高の設定
		myAcc.setBalance(291940);
		
		//getterを用いた表示
		System.out.println("Account Number: "+ myAcc.getAccNum()); //口座番号
		System.out.println("Password: "+ myAcc.getPass()); //暗証番号
		System.out.println("Balance: "+ myAcc.getBalance() + "JPY"); //残高
		
		//***********************************
		// 課題 [2] 
		//***********************************
		
		//TestATMインスタンス化
		TestATM atm = new TestATM(myAcc);
		
		//[2]-1		
		int deposit = 2500; //入金額
		System.out.println("Start deposit: "+ deposit + " JPY");
		atm.deposit(deposit); //入金処理
		atm.showCurrentBalance(); //表示
		
		//[2]-2
		int withdraw = 1100; //出金希望額
		System.out.println("Start withdraw: "+ withdraw + " JPY");
		atm.withdraw(withdraw); //出金処理
		atm.showCurrentBalance(); //表示
		
		
		//[2]-3
		withdraw = 1120000; //出金希望額
		System.out.println("Start withdraw: "+ withdraw + " JPY");
		atm.withdraw(withdraw); //出金処理
		atm.showCurrentBalance(); //表示		
	}
}
