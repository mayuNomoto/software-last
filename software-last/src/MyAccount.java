

public class MyAccount {

	private int m_accNum;
	private int m_password;
	private int m_balance;

	//Constructor
	public MyAccount()
	{}

	//getter

	//口座番号を取得
	public int getAccNum()
	{
		return m_accNum;
	}

	//暗証番号を取得
	public int getPass()
	{
			return m_password;
	}

	//残高を取得
	public int getBalance()
	{
		return m_balance;
	}

	//setter

	//口座番号を設定
	public void setAccNum(int accnum)
	{
		this.m_accNum = accnum;
	}

	//暗証番号を設定
	public void setPass(int pass)
	{
		this.m_password = pass;
	}

	//残高を設定
	public void setBalance(int balance)
	{
		this.m_balance = balance;
	}
}
