import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class DepositWithdrawForm {

	MyATM atm;
	Scene scene;
	ATMmainForm mainForm;
	Stage stage;
	String type;
	String amount = "";


	public void setType(String type) {
		this.type = type;
	}


	public DepositWithdrawForm(MyATM atm, Stage stage) {
		this.atm = atm;
		this.stage = stage;
	}
	
	
	public void prepareScene() {
		// TODO Auto-generated method stub
		
		BorderPane root = new BorderPane();
		
		Label transaction = new Label();
		Label amountLabel = new Label();
		Button enterTransaction = new Button("Enter");
		Button clear = new Button("Clear");
		Button returnToMainForm = new Button("Return");
		
		GridPane grid = new GridPane();
		HBox hbox = new HBox();
		VBox vbox = new VBox();
		
		Button[] numpad = new Button[10];
		for(int i=0; i<3;i++) {
			for(int j=0; j<3; j++) {
				numpad[i*3+j] = new Button();
				numpad[i*3+j].setText(String.valueOf(i*3+j+1));
				grid.add(numpad[i*3+j], j+1, i+1);
				int x = i*3+j;
				numpad[i*3+j].setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						if(amount.length() > 5)
							return;
						amount += numpad[x].getText();
						amountLabel.setText(amount);
					}
				});
			}
		}
		
		numpad[9] = new Button();
		numpad[9].setText("0");
		grid.add(numpad[9], 2, 4);
		
		numpad[9].setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(amount.length() > 5)
					return;
				amount += "0";
				amountLabel.setText(amount);
			}
		});
		
		hbox.getChildren().addAll(enterTransaction,clear,returnToMainForm);
		transaction.setAlignment(Pos.BASELINE_CENTER);
		amountLabel.setMaxWidth(Double.MAX_VALUE);
		transaction.setMaxWidth(Double.MAX_VALUE);
		amountLabel.setAlignment(Pos.BASELINE_CENTER);
		grid.setAlignment(Pos.BASELINE_CENTER);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		vbox.setSpacing(10);
		vbox.getChildren().addAll(amountLabel,grid,hbox,transaction);
		root.setCenter(vbox);

		
		
		enterTransaction.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(amount == "")
					return;
				
				if(type == "withdraw") {
					if( Integer.valueOf(atm.currentBalance) - Integer.valueOf(amount)>0) {
						atm.withdraw(amount);
						transaction.setText("Withdrawed " + amount +" Successfully" );
					}else {
						transaction.setText("Transaction Failed");
					}
				}else if(type == "deposit") {
					atm.deposit(amount);
					transaction.setText("Deposited " + amount + " Successfully" );
				}
				
				amountLabel.setText("");
				amount = "";
			}
		});
		
		
		returnToMainForm.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				amount = "";
				transaction.setText("");
				amountLabel.setText("");
				stage.setScene(mainForm.getScene());
			}
		});
		
		clear.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				amount = "";
				transaction.setText("");
				amountLabel.setText("");
			}
		});
		

		
		
		scene = new Scene(root, 300,220);
	}
	
	
	public void setMainForm(ATMmainForm mainForm) {
		this.mainForm = mainForm;
	}
	
	public Scene getScene() {
		return this.scene;
	}
}
