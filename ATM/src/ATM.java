
public interface ATM {
	//Returns the current balance in string format
	public String getCurrentBalance();
	//withdraws from current balance and updates it
	public void withdraw(String amount);
	//adds to the current balance and updates it
	public void deposit(String amount);
	//returns the prev transaction in String format, or Null if no more history
	public String prev();
	//returns the next transaction in String format, or Null if no more history
	public String next();
}
