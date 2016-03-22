package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import util.AppLogic;
import util.NumberTextField;

public class NumberViewerController implements Initializable{

    @FXML
    private GridPane mainGridPane;

    @FXML
    private Label waitingOrdersLabel;

    @FXML
    private Separator topSeparator;

    @FXML
    private Label doneOrdersLabel;

    @FXML
    private Separator centralSeparator1;

    @FXML
    private HBox addBox;

    @FXML
    private NumberTextField addNumberField;

    @FXML
    private Button addButton;

    @FXML
    private Separator bottomSeparator;

    @FXML
    private GridPane lefPanel;

    @FXML
    private Button b00;

    @FXML
    private Button b01;

    @FXML
    private Button b02;

    @FXML
    private Button b03;

    @FXML
    private Button b10;

    @FXML
    private Button b11;

    @FXML
    private Button b12;

    @FXML
    private Button b13;

    @FXML
    private Button b20;

    @FXML
    private Button b21;

    @FXML
    private Button b22;

    @FXML
    private Button b23;

    @FXML
    private Button b30;

    @FXML
    private Button b31;

    @FXML
    private Button b32;

    @FXML
    private Button b33;

    @FXML
    private Button b40;

    @FXML
    private Button b41;

    @FXML
    private Button b42;

    @FXML
    private Button b43;

    @FXML
    private HBox buttonBox;

    @FXML
    private Button clearButton;

    @FXML
    private GridPane rightPanel;

    @FXML
    private TextField t00;

    @FXML
    private TextField t01;

    @FXML
    private TextField t02;

    @FXML
    private TextField t10;

    @FXML
    private TextField t11;

    @FXML
    private TextField t12;

    @FXML
    private TextField t20;

    @FXML
    private TextField t21;

    @FXML
    private TextField t22;

    @FXML
    private TextField t30;

    @FXML
    private TextField t31;

    @FXML
    private TextField t32;

    @FXML
    private TextField t40;

    @FXML
    private TextField t41;

    @FXML
    private TextField t42;

    private AppLogic model;
    private Button[][] buttons;
    private TextField[][] fields;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new AppLogic();
		buttons = new Button[][] {
			{ b00, b01, b02, b03 },
			{ b10, b11, b12, b13 },
			{ b20, b21, b22, b23 },
			{ b30, b31, b32, b33 },
			{ b40, b41, b42, b43 }};
		fields = new TextField[][] {
			{ t00, t01, t02 },
			{ t10, t11, t12 },
			{ t20, t21, t22 },
			{ t30, t31, t32 },
			{ t40, t41, t42 }};
		initializeTables();
		addButtonAction();
		clearButtonAction();
		numberButtonAction();
	}
	
	// Akcja przycisku nowej pozycji
	private void addButtonAction() {
		addButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				if (validateTextFieldContent() == true) {
					if (validateDoubleInstance() == false) {
						if (!(addNumberField.getText().equals(new String("")))) {
							if (model.getLeftClock() == 20) {
								addNumberField.setText("PEŁNY!");
							} else {
								model.addLeftTableField(addNumberField.getText());
								refreshButtonsText();
								clearNumberField();
							}
						}
					} else {
						addNumberField.setText("ISTNIEJE!");
					}
				}
			}
		});
	}
	
	// Akcja przycisków z numerami
	private void numberButtonAction() {
		
		for (int i=0; i < buttons.length; i++) {
			for (int j=0; j < buttons[i].length; j++) {
				int x = i, y = j; 
				buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						if (!(buttons[x][y].getText().equals(new String("")))) {
							if (model.getRightClock() == 15) {
								addNumberField.setText("WYCZYŚĆ!");
							} else {
								model.addRightTableField(buttons[x][y].getText());
								model.clearLeftTableField(buttons[x][y].getText());
								clearNumberField();
								refreshButtonsText();
								refreshFieldsText();
							}
						} 
					}
				});
			}
		}
	}
	
	// Akcja przycisku czyść
	private void clearButtonAction() {
		clearButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				model.clearRightTable();
				refreshFieldsText();
			}
		});
	}
	
	
	// Czyszczenie pola NumberField
	private void clearNumberField() {
		addNumberField.setText("");
	}
	
	// Odświeżanie tekstów przycisków
	private void refreshButtonsText() {
		int counter = 1;
		for (int i=0; i < buttons.length; i++) {
			for (int j=0; j <buttons[i].length; j++) {
		
				buttons[i][j].setText(model.getLeftTableField(counter));
				counter++;
			}
		}
	}
	// Odświeżanie tekstów pól
	private void refreshFieldsText() {
		int counter = 1;
		for (int i=0; i < fields.length; i++) {
			for (int j=0; j <fields[i].length; j++) {
		
				fields[i][j].setText(model.getRightTableField(counter));
				counter++;
			}
		}
	}
	// Sprawdzanie czy w tablicy istnieje numer podany w polu AddNumberField
	private boolean validateDoubleInstance() {
		return model.validate(addNumberField.getText());
	}
	

	// Sprawdzanie czy w polu NumberField nie znajduje się komunikat aplikacji
	private boolean validateTextFieldContent() {
		if(!addNumberField.getText().matches("[0-9]{1,4}")) {
			addNumberField.setText("");
			return false;
		} 
		return true;
	}
	
	// Inicjalizacja tablic
	private void initializeTables() {
		model.fillTables();
	}

}
