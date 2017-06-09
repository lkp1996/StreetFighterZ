package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainView extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
	try {
	    MainController ctrl;

	    FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(getClass().getResource("StreetFighterZMain.fxml"));
	    GridPane root = (GridPane) loader.load();

	    ctrl = (MainController) loader.getController();
	    ctrl.init();

	    Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("StreetFighterZ");
	    primaryStage.show();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
    }

}
