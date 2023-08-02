package learning;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import odometer.Odometer;

public class OdometerView {
	
	private Odometer odometer;
	private OdometerController controller;
	
	private Text reading;
	private HBox readingBoxesContainer;
	private List<StackPane> readingBoxes;
	private Button increment;
	private Button decrement;
	private Button reset;
	private TextField odometerSize;
	private Button resize;
	private Scene scene;
	
	public OdometerView(Odometer odometer, OdometerController controller) {
		this.odometer = odometer;
		this.controller = controller;
		initComponents();
		setScene();
	}
	
	private void initComponents() {
		reading = new Text();
		reading.setText(odometer.toString());
		
		updateReading();
		increment = getButtonFor(OdometerAction.INCREMENT);
		decrement = getButtonFor(OdometerAction.DECREMENT);
		reset = getButtonFor(OdometerAction.RESET);
		odometerSize = new TextField();
		resize = getButtonFor(OdometerAction.RESIZE);
	}
	
	public Button getButtonFor(OdometerAction action) {
		Button button = new Button();
		button.setText(action.toString());
		button.setOnAction(event -> {
			switch(action) {
			case INCREMENT:
				controller.increment();
				break;
			case DECREMENT:
				controller.decrement();
				break;
			case RESET:
				controller.reset();
				break;
			case RESIZE:
				controller.resize(Integer.valueOf(odometerSize.getText()));
				break;
			}
			updateReading();
		});
		return button;
	}
	
	private void setScene() {
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		//grid.add(reading, 0, 0, 2, 1);
		grid.add(readingBoxesContainer, 0, 0, 2, 1);
		
		grid.add(increment, 0, 1);
		grid.add(decrement, 1, 1);
		grid.add(reset, 2, 1);
		grid.add(odometerSize, 0, 2);
		grid.add(resize, 1, 2);
		
		scene = new Scene(grid, 600, 600);
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void updateReading() {
		//reading.setText(odometer.toString());
		readingBoxes = new ArrayList<>();
		for (int i = 0; i < odometer.getSize(); i++) {
			Rectangle r = new Rectangle(20, 20);
			r.setFill(Color.WHITE);
			Text t = new Text();
			t.setText(String.valueOf(odometer.getReading()).substring(i, i+1));
			StackPane box = new StackPane();
			box.getChildren().add(r);
			box.getChildren().add(t);
			readingBoxes.add(box);
		}
		if (readingBoxesContainer == null)
			readingBoxesContainer = new HBox();
		readingBoxesContainer.getChildren().clear();
		readingBoxesContainer.getChildren().addAll(readingBoxes);
	}
}
