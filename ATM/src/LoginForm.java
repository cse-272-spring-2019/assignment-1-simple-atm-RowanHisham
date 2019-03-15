import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginForm {
	MyATM atm;
	Scene scene;
	ATMmainForm mainForm;
	Stage stage;
	String number = "";
	
	public LoginForm(MyATM atm, Stage stage) {
		// TODO Auto-generated constructor stub
		this.atm = atm;
		this.stage = stage;
	}
	
	
	public void prepareScene() {
		// TODO Auto-generated method stub
		
		Label login = new Label("Enter Card Number");
		Label numberLabel = new Label();
		Button enter = new Button("Login");
		Button reset = new Button("Reset");
		
		BorderPane root = new BorderPane();
		GridPane grid = new GridPane();
		HBox hbox = new HBox();
		HBox hbox2 = new HBox();
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
						if(number.length() > 2)
							return;
						number += numpad[x].getText();
						numberLabel.setText(number);
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
				if(number.length() > 2)
					return;
				number += "0";
				numberLabel.setText(number);
			}
		});
		
		
		hbox.getChildren().addAll(login,numberLabel);
		hbox2.getChildren().addAll(enter,reset);
		//vbox.setAlignment(Pos.BASELINE_CENTER);
		
		login.setMaxWidth(Double.MAX_VALUE);
		numberLabel.setMaxWidth(Double.MAX_VALUE);
		login.setAlignment(Pos.BASELINE_CENTER);
		numberLabel.setAlignment(Pos.BASELINE_CENTER);
		grid.setAlignment(Pos.BASELINE_CENTER);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		hbox2.setAlignment(Pos.BASELINE_CENTER);
		
		vbox.setSpacing(10);
		vbox.getChildren().addAll(login,numberLabel,hbox,grid,hbox2);
		//vbox.setAlignment(Pos.BASELINE_CENTER);

		root.setCenter(vbox);
		
		
		enter.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(number.contentEquals(atm.getCardNumber())) {
					stage.setScene(mainForm.getScene());
				}else {
					numberLabel.setText("Wrong Card Number");
					number = "";
				}
			}
		});

		
		reset.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				number = "";
				numberLabel.setText("");
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
