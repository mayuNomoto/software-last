

public class TestATM {

	//メンバ変数
	private MyAccount m_myAcc;
	
	//Constructor
	public TestATM(MyAccount acc)
	{
		m_myAcc = acc;		
	}
	
	//入金処理
	public void deposit (int cash_deposit)
	{
		//現在の残高取得
		int current = m_myAcc.getBalance();

		//残高更新（現在の残高+入金額）
		m_myAcc.setBalance(current + cash_deposit);		
	}
	
	//出金処理
	public void withdraw(int cash_want)
	{
		//現在の残高取得
		int current = m_myAcc.getBalance();
		
		//出金希望額の方が多い場合
		if (current < cash_want)
		{
			System.out.println("Can't withdraw: " + cash_want + " JPY");
			System.out.println("Your current balance is: "+ current + " JPY");			
		}
		
		//出金できる場合、残高を更新（現在の残高-出金額）
		else
		{
			m_myAcc.setBalance(current - cash_want);
		}		
	}
	
	//残高表示処理
	public void showCurrentBalance()
	{
		int current = m_myAcc.getBalance();
		
		System.out.println("Current balance: "+ current + " JPY");		
	}	
	
	//1年後の預金予想
	public void afterdep() {
		int current=m_myAcc.getBalance();
		double cash=current*1.1;
		System.out.println("1年後の預金予想："+cash+" JPY");
	}
}
