package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CharSelectView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
	try {
	    CharSelectController ctrl;

	    FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(getClass().getResource("StreetFighterZCharSelect.fxml"));
	    GridPane root = (GridPane) loader.load();

	    ctrl = (CharSelectController) loader.getController();
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
