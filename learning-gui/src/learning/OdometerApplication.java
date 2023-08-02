package learning;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import odometer.Odometer;

public class OdometerApplication extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		
		Odometer o = new Odometer(5);
		OdometerController controller = new OdometerController(o);
		OdometerView view = new OdometerView(o, controller);
		
		stage.setTitle("Odometer");
		stage.setScene(view.getScene());
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
