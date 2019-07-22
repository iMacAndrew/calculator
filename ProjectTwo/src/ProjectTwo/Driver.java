/*
 * 
 */

package ProjectTwo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Driver extends Application {
	
	public static void main(String[] args) {
		
		/*LargeNumber number1 = new LargeNumber("10");
		LargeNumber number2 = new LargeNumber("6");
		System.out.println(number1.subtractNumbers(number2));
		
		LargeNumber number3 = new LargeNumber("1000");
		LargeNumber number4 = new LargeNumber("502");
		System.out.println(number3.subtractNumbers(number4));
		
		LargeNumber number5 = new LargeNumber("101");
		LargeNumber number6 = new LargeNumber("1");
		System.out.println(number5.subtractNumbers(number6));
		*/
		
		launch(args);
	}
	
	/**
	 * Boilerplate for FXML
	 */
	@Override
    public void start(Stage stage) throws Exception {
		Controller controller = new Controller();
		// Boilerplate
		Parent root = FXMLLoader.load(controller.getClass().getClassLoader().getResource("View.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
	
}
