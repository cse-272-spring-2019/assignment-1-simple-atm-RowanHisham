import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.application.*;
import javafx.util.*;

public class ATMapp extends Application {
	
	MyATM atm = new MyATM();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		

		primaryStage.setTitle("ATM");
		ATMmainForm mainForm = new ATMmainForm(atm, primaryStage);
		LoginForm loginForm = new LoginForm(atm,primaryStage);
		DepositWithdrawForm  depositWithdrawForm = new DepositWithdrawForm(atm, primaryStage);
		loginForm.prepareScene();
		mainForm.prepareScene();
		depositWithdrawForm.prepareScene();
		mainForm.setDepositWithdrawForm(depositWithdrawForm);
		depositWithdrawForm.setMainForm(mainForm);
		loginForm.setMainForm(mainForm);
		primaryStage.setScene(loginForm.getScene());
		primaryStage.show();
		
		
	}
	
	

}
