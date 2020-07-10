
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
		
		//ArrayList<MyAccount> myAcc = new ArrayList<MyAccount>();
		
		//System.out.println("作る口座の数を設定してください");
		//int n = sc.nextInt();
		
		//以下、学籍番号G20194の例
		//口座番号の設定
		//for(int i=0;i>n;i++) {
		System.out.println("口座番号を設定してください");
		//int acc = sc.nextInt();
		
		myAcc.setAccNum(sc.nextInt());
		
		//暗証番号の設定
		System.out.println("暗証番号を設定してください");
		//int pass = sc.nextInt();
		myAcc.setPass(sc.nextInt());
		
		
		//残高の設定
		//System.out.println("初期残高を設定してください");
		//int bal = sc.nextInt();
		myAcc.setBalance(291940);
		
		//MyAccount acc1 =new MyAccount(acc,pass,bal);
		//myAcc.add(acc1);
		//}
		
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
				System.out.println("1:普通預金か2:定期預金か選択してください");
				int dep = sc.nextInt();
				if(dep == 1) {
					System.out.println("Start deposit: "+ deposit + " JPY");
					atm.deposit(deposit); //入金処理
					atm.showCurrentBalance(); //表示
				}
				if(dep == 2) {
					System.out.println("新しく口座を作ります");
					MyAccount myAcc2 =new MyAccount();
					System.out.println("口座番号を設定してください");
					myAcc2.setAccNum(sc.nextInt());
					System.out.println("暗証番号を設定してください");
					myAcc2.setPass(sc.nextInt());
					myAcc2.setBalance(0);
					TestATM atm2 = new TestATM(myAcc2);
					System.out.println("Start deposit: "+ deposit + " JPY");
					atm2.deposit(deposit); //入金処理
					atm2.showCurrentBalance(); //表示
					atm2.afterdep();
				}
				
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
				System.out.println("振込先の口座を指定してください");
				int payee = sc.nextInt(); //振込先の口座番号
				int money = sc.nextInt(); //振込額
				System.out.println("Start withdraw: "+ money + " JPY");
				atm.withdraw(money); //出金処理
				atm.showCurrentBalance(); //表示
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
