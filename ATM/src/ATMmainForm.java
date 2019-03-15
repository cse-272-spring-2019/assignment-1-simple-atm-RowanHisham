import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class ATMmainForm{
	
	MyATM atm;
	Scene scene;
	DepositWithdrawForm depositWithdrawForm;
	Stage stage;

	public ATMmainForm(MyATM atm, Stage stage) {
		this.atm = atm;
		this.stage = stage;
	}
	
	
	public void prepareScene() {
		// TODO Auto-generated method stub
		
		
		Label accountData = new Label();
		Button depositButton = new Button("Deposit");
		Button withdrawButton = new Button("Withdraw");
		Button balanceButton = new Button("Balance Inquiry");
		Label history = new Label("History: ");
		Button prevButton = new Button("Previous");
		Button nextButton = new Button("Next");
		
		BorderPane root = new BorderPane();
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		
		vbox.getChildren().addAll(depositButton,withdrawButton,balanceButton,accountData,history);
		hbox.getChildren().addAll(prevButton,nextButton);
		vbox.getChildren().add(hbox);
		hbox.setSpacing(10);
		vbox.setSpacing(10);
		
		vbox.setAlignment(Pos.BASELINE_CENTER);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		root.setCenter(vbox);
		
		
		
		balanceButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				accountData.setText("Balance: " + atm.getCurrentBalance());
			}
		});
		
		prevButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String prev = atm.prev();
				if(prev != null)
					accountData.setText(prev);
			}
			
		});
		
		nextButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String next = atm.next();
				if(next != null)
					accountData.setText(next);

			}
		});
		
		depositButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				depositWithdrawForm.setType("deposit");
				stage.setScene(depositWithdrawForm.getScene());
			}
		});
		
		withdrawButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				depositWithdrawForm.setType("withdraw");
				stage.setScene(depositWithdrawForm.getScene());
			}
		});
		
		
		scene = new Scene(root, 300,220);
	}
	
	public Scene getScene() {
		return this.scene;
	}

	public void setDepositWithdrawForm(DepositWithdrawForm form) {
		this.depositWithdrawForm = form;
	}
}
