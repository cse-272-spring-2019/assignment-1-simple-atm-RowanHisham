
public class Transaction {

	private String transactionType ;
	private String transactionAmount;
	static int currentTransaction = 0;
    static int currentTransactionDisplayed = 0;
	
	public Transaction(String transactionType,String transactionAmount) {
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
	}
	
	public String returnTransactionData() {
		return transactionType + " : " + transactionAmount;
	}
	
	
}
