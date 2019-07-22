package ProjectTwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/*
 * Andy Humphries
 * Some assistance from Ben.
 */

public class Controller {
	
	@FXML
	private TextField textField;
	private	LargeNumber firstTextEntered;
	private boolean isAdd = false;
	public void start() {
		
	}
	
	@FXML
	/**
	 * When a button is clicked it adds itself to the text field 
	 * @param e
	 */
	public void clickedButton(ActionEvent e) {
		Button button = (Button) e.getSource();
		textField.appendText(button.getText());
	}
	
	/**
	 * When the add button is clicked it empties the text field and changes the boolean isAdd to true
	 * @param e
	 */
	public void clickedAdd(ActionEvent e) {
		Button button = (Button) e.getSource();
		firstTextEntered = new LargeNumber(textField.getText());
		textField.setText("");
		isAdd = true;
		
	}
	
	/**
	 * When the subtract button is clicked it empties the text field and changes the boolean isAdd to false
	 * @param e
	 */
	public void clickedSubtract(ActionEvent e) {
		Button button = (Button) e.getSource();
		firstTextEntered = new LargeNumber(textField.getText());
		textField.setText("");
		isAdd = false;
		
	}
	
	/**
	 * Clears the text field
	 * @param e
	 */
	public void clickedClear(ActionEvent e) {
		Button button = (Button) e.getSource();
		textField.setText("");
	}
	
	/**
	 * Calls the add and subtracts methods on the numbers that were entered in
	 * @param e
	 */
	public void clickedEquals(ActionEvent e) {
		Button button = (Button) e.getSource();
		LargeNumber secondTextEntered = new LargeNumber(textField.getText());
				
		LargeNumber result;
		
		if (isAdd) {
			result = firstTextEntered.addNumbers(secondTextEntered);
			textField.setText(result.toString());
		}
		else {
			result = firstTextEntered.subtractNumbers(secondTextEntered);
			textField.setText(result.toString());
		}
			
	}
	
}
