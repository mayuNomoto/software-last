import java.util.*;

public class Main {
	static ArrayList<MyAccount> myAcc;
	static MyAccount a;
	
	public static void main (String [] args) {
		select();
	}

	public static void select() {
		Scanner sc = new Scanner(System.in);
		for(;;) {
		System.out.println("機能を選択してください");
		System.out.println("1: 口座設定");
		System.out.println("2: 口座アクセス");
		System.out.println("3: 終了");
		int option = sc.nextInt();
		if (option == 1) {
			setting();
		}
		else if(option ==2) {
			accessAcc();
		}
		else {
			System.exit(0);
		}
	}
    }
	public static void setting() {		
		myAcc= new ArrayList<MyAccount>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("作る口座の数を設定してください");
		int n = sc.nextInt();
		
		//口座番号の設定
		for(int i=0;i<n;i++) {
		System.out.println("口座番号を設定してください");
		int acc = sc.nextInt();		
		//myAcc.setAccNum(sc.nextInt());
		
		//暗証番号の設定
		System.out.println("暗証番号を設定してください");
		int pass = sc.nextInt();
		//myAcc.setPass(sc.nextInt());
		
		//残高の設定
		System.out.println("初期残高を設定してください");
		int bal = sc.nextInt();
		//myAcc.setBalance(291940);
		
		MyAccount accn =new MyAccount(acc,pass,bal);
		myAcc.add(accn);
		}
	}	

	public static void accessAcc() {

		Scanner sc=new Scanner(System.in);
		System.out.println("口座番号を入力してください");
		int scAccNum=sc.nextInt();
		System.out.println("暗証番号を入力してください");
		int scAccPass=sc.nextInt();
		
		for(int i=0;i<myAcc.size();i++) {
			if(myAcc.get(i).getAccNum()==scAccNum) {
				if(myAcc.get(i).getPass()==scAccPass) {
				    a=new MyAccount(scAccNum,myAcc.get(i).getPass(),myAcc.get(i).getBalance());
				    break;
				}else {
				    System.out.println("暗証番号が違います");
				    accessAcc();
				}
			}
		}
		TestATM atm = new TestATM(a);
		for (;;) {
			System.out.println("機能を選択してください");
			System.out.println("1:　入金");
			System.out.println("2: 出金");
			System.out.println("3: 残高照会");
			System.out.println("4: 振り込み");
			System.out.println("5:　キャッシング");
			System.out.println("6: 終了");
			
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
					//MyAccount myAcc2 =new MyAccount();
					System.out.println("口座番号を設定してください");
					int acc = sc.nextInt();
					//myAcc2.setAccNum(sc.nextInt());
					System.out.println("暗証番号を設定してください");
					int pass = sc.nextInt();
					//myAcc2.setPass(sc.nextInt());
					//myAcc2.setBalance(0);	
					MyAccount accn =new MyAccount(acc,pass,0);
					myAcc.add(accn);
					
					for(int i=0;i<myAcc.size();i++) {
						if(myAcc.get(i).getAccNum()==scAccNum) {
							if(myAcc.get(i).getPass()==scAccPass) {
							    a=new MyAccount(scAccNum,myAcc.get(i).getPass(),myAcc.get(i).getBalance());
							    break;
							}else {
							    System.out.println("暗証番号が違います");
							    accessAcc();
							}
						}
					}
					TestATM atm2 = new TestATM(a);
					
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
				System.out.println("振り込み額を入力してください");
				int money = sc.nextInt(); //振込額
				System.out.println("Start withdraw: "+ money + " JPY");
				for(int i=0;i<myAcc.size();i++) {
					if(myAcc.get(i).getAccNum()==payee) {
						a=new MyAccount(payee,myAcc.get(i).getPass(),myAcc.get(i).getBalance());
						break;
					}
				}
				TestATM toAtm = new TestATM(a);
				atm.withdraw(money); //出金処理
				atm.showCurrentBalance(); //表示
				toAtm.deposit(money);
		}
			else if (option == 5) {
				System.out.println("借りたい金額を入力してください");
				int dbmoney = sc.nextInt(); //借金額
				a.debt(a.getDebt()+dbmoney);
				System.out.println("現在の借金額は"+ a.getDebt());
				
				
			}
			else if (option == 6) {
			select();
		}
		else {
			System.out.println("１から４の数字を入力してください");
		}
		}
	}
}
