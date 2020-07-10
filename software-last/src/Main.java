
import java.util.*;


public class Main {

	public static void main (String [] args) 
	{
		
		//***********************************
		// 課題 [1] 
		//***********************************
		Scanner sc = new Scanner(System.in);
		//MyAccount インスタンス化
		MyAccount myAcc = new MyAccount();
		
		//以下、学籍番号G20194の例：

		//口座番号の設定
		System.out.println("口座番号を設定してください");
		myAcc.setAccNum(sc.nextInt());
		
		//暗証番号の設定
		System.out.println("暗証番号を設定してください");
		myAcc.setPass(sc.nextInt());
		
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
		for (;;) {
			System.out.println("機能を選択してください");
			System.out.println("1: 入金");
			System.out.println("2: 出金");
			System.out.println("3: 残高照会");
			System.out.println("4: 振り込み");
			 System.out.println("5: 終了");
			
			int option = sc.nextInt();
			if (option == 1) {
				System.out.println("入金額を入力してください");
				int deposit = sc.nextInt();
				System.out.println("Start deposit: "+ deposit + " JPY");
				atm.deposit(deposit); //入金処理
				atm.showCurrentBalance(); //表示
			}
			
			//[2]-2
			else if (option == 2 ) { 
				System.out.println("出金額を入力してください");
				int withdraw = sc.nextInt(); //出金希望額
				System.out.println("Start withdraw: "+ withdraw + " JPY");
				atm.withdraw(withdraw); //出金処理
				atm.showCurrentBalance(); //表示
		}
			else if (option == 3) {
			atm.showCurrentBalance(); //表示
		}
			else if (option == 4) {
			//振り込み処理を書いてね
		}
			else if (option == 5) {
			System.exit(0);
		}
		else {
			System.out.println("１から４の数字を入力してください");
		}
		}
	}
}
