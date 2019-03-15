
import java.util.*;  


public class MyATM implements ATM {
	
	String currentBalance = "0";
	String cardNumber = "123";
	LinkedList<Transaction> list= new LinkedList<Transaction>();

	
	public LinkedList<Transaction> getList() {
		return list;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	//Returns the current balance in string format
	public String getCurrentBalance() {
		
		list.addFirst(new Transaction("Balance Inquiry", currentBalance));
		
		
		if (++Transaction.currentTransaction > 5 ) {
			list.removeLast();	
			Transaction.currentTransaction = 5;
			Transaction.currentTransactionDisplayed = 0;
		}
		
		return currentBalance;
	}
	
	//withdraws from current balance and updates it
	public void withdraw(String amount) {	
			currentBalance = String.valueOf(String.valueOf(Integer.parseInt(currentBalance) - Integer.parseInt(amount)));
		
			list.addFirst(new Transaction("Withdraw",amount));
			
			if (++Transaction.currentTransaction > 5 ) {
				list.removeLast();	
				Transaction.currentTransaction = 5;
			}
	}
	
	//adds to the current balance and updates it
	public void deposit(String amount) {
		currentBalance =  String.valueOf(Integer.parseInt(currentBalance) + Integer.parseInt(amount));
		
		list.addFirst(new Transaction("Deposit",amount));
		
		if (++Transaction.currentTransaction > 5 ) {
			list.removeLast();	
			Transaction.currentTransaction = 5;
		}	
	}
	
	//returns the prev transaction in String format, or Null if no more history
	public String prev() {
		if(Transaction.currentTransactionDisplayed+1 >= list.size()) {
			return null;
		}else
			return list.get(++Transaction.currentTransactionDisplayed).returnTransactionData();
	}
	
	//returns the next transaction in String format, or Null if no more history
	public String next() {
		if(Transaction.currentTransactionDisplayed == 0 ) {
			return null;
		}else
			return list.get(--Transaction.currentTransactionDisplayed).returnTransactionData();
	}
	
}
