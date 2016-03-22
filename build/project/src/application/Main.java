package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("NumberViewer.fxml"));
			Scene scene = new Scene(root,620 ,410);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.initStyle(StageStyle.UTILITY);
			primaryStage.setScene(scene);
			primaryStage.setMinWidth(632);
			primaryStage.setMinHeight(440);
			primaryStage.setAlwaysOnTop(true);
			primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
